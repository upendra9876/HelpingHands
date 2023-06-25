package com.helpinghands.HelpingHands.services;



import com.helpinghands.HelpingHands.dto.ReportIncident;
import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.exception.ValidIncidentidexception;
import com.helpinghands.HelpingHands.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.sound.sampled.FloatControl;
import java.lang.invoke.WrongMethodTypeException;
import java.time.LocalDate;
import java.util.*;

@Service

public class incidenttrackserviceimpletation implements Incidenttrackservice{
    @Autowired
    private Temporarydatabaseofincidentdao temporarydatabaseofincidentdao;

    @Autowired
    private Centralrepositoryofincidentdao centralrepositoryofincidentdao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private Locationdao locationdao;



@Override
    public Location reportTheIncident(ReportIncident incident1, String userId) throws Exception {

        try {
            Users user= userDao.findById(userId).get();
            String error="NO USer exist with id"+userId;

                String postalcode= getPostalByUserId(userId);
                Location location= locationdao.findById(postalcode).get();
                Temporarydatabaseofincident incident= new Temporarydatabaseofincident();
                incident.setId(incident1.getId());
                incident.setName(incident1.getName());
                incident.setIncidentDate(incident1.getIncidentDate());
                incident.setCasualty(incident1.getCasualty());
                incident.setStatus(false);
                incident.setState(incident1.getState());
                incident.setDistrict(incident1.getDistrict());
                incident.setDescription(incident1.getDescription());

                List<Temporarydatabaseofincident> incidents= location.getTemporarydatabaseofincidents();
                List<Temporarydatabaseofincident> userincident= user.getTemporarydatabaseofincidents();
                user.setTemporarydatabaseofincidents(userincident);
                location.setTemporarydatabaseofincidents(incidents);
                userincident.add(incident);
                incidents.add(incident);
                userDao.save(user);
                locationdao.save(location);

                temporarydatabaseofincidentdao.save(incident);
                return location;
        }
        catch (Exception exc){
            throw new Exception("Please enter valid userId");
        }




    }

    @Override
    public void incidentVerificationByAdmin(String incidentId) throws NoSuchElementException {
        try{
            String postal= getPostalByIncidentId(incidentId);
            Location location = locationdao.findById(postal).get();

                location.setTotaldisaster(location.getTotaldisaster()+1);
                Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();
                locationdao.save(location);
                incident.setStatus(true);
                temporarydatabaseofincidentdao.save(incident);

        }catch(Exception exc){
            throw new NoSuchElementException("please enter valid incidentId");
        }


    }

    @Override
    public List<Centralrepositoryofincident> findAllIncidentInArea(String postalcode) throws NoSuchElementException{
        Location location;
        try
        {
           location  = locationdao.findById(postalcode).get();
            return location.getCentralrepositoryofincidentList();
        }
        catch (Exception ae)
        {
            throw new NoSuchElementException("PLease enter valid postal code");
        }


    }

    @Override
    public List<Object> findTotalIncidentApproveByAdmin( String adminId) throws Exception {
        try {
            Admin admin = adminDao.findById(adminId).get();
            List<Object> list = new ArrayList<>();
            String postal = getPostalByAdminId(adminId);
            Location location = locationdao.findById(postal).get();

            List<Centralrepositoryofincident> list1 = location.getCentralrepositoryofincidentList();
            for (Centralrepositoryofincident i : list1) {
                list.add(i);
            }
            List<Temporarydatabaseofincident> list2 = location.getTemporarydatabaseofincidents();
            for (Temporarydatabaseofincident j : list2) {
                if (j.isStatus()) list.add(j);
            }
            if(list.size()>0) return list;
            else throw new EmptyListException("fg");
        }
        catch (NoSuchElementException exc){
            throw new NoSuchElementException("Please Enter Valid AdminId");
        }
        catch (EmptyListException exc){
            throw new EmptyListException("no incident verify by admin");
        }
        catch (Exception exc){
            throw new Exception("error Occured");
        }
    }


    @Override
    public long totalCasualityByIncident(String incidentid) {
        try{
            Centralrepositoryofincident incident= centralrepositoryofincidentdao.findById(incidentid).get();
             return incident.getCasualty();
        }
        catch (Exception e){
            throw new NoSuchElementException("Please Enter valid incidentId");
        }


    }

    @Override
    public long overallCasualitiesByIncidentsInArea(String postal) throws NoSuchElementException {
        try{
            Location location= locationdao.findById(postal).get();
            long totalcasuality=0;
            List<Centralrepositoryofincident> incidents= location.getCentralrepositoryofincidentList();
            for( Centralrepositoryofincident i : incidents){
                totalcasuality=totalcasuality+i.getCasualty();

            }
            return totalcasuality;

        }catch(Exception exc){
            throw new NoSuchElementException("invalid postal code");
        }
    }

    @Override
    public List<Object> findAllIncidentRaiseByUser(String userid) throws EmptyListException {
        try{
            List<Object> answerlist= new ArrayList<>();
            Users user= userDao.findById(userid).get();
            List<Centralrepositoryofincident> incidents= user.getCentralrepositoryofincidents();
            List<Temporarydatabaseofincident> incidentss= user.getTemporarydatabaseofincidents();
            for( Centralrepositoryofincident i : incidents) answerlist.add(i);
            for(Temporarydatabaseofincident i : incidentss) answerlist.add(i);
            if(answerlist.size()>0) return answerlist;
            else throw new EmptyListException("user has not raise any incident");

        }catch(NoSuchElementException e){
            throw new NoSuchElementException("invalid userId");
        }
        catch (EmptyListException exc){
            throw new EmptyListException("user has not raise any incident");
        }


    }

    // temporaryincident
    @Override
    public Users getUserByIncident(String incidentid){
        try{
            Centralrepositoryofincident incident = centralrepositoryofincidentdao.findById(incidentid).get();
            Location location = locationdao.findById(getPostalByIncidentId(incidentid)).get();
            List<Users> users = location.getUsers();
            for( Users i : users){
                List<Centralrepositoryofincident> incidents= i.getCentralrepositoryofincidents();

                for( Centralrepositoryofincident j : incidents){
                    if(j.getId().equals(incidentid)) return i;
                }

            }

        }catch(Exception exc){
            throw new NoSuchElementException("please Enter valid incidentId");
        }


        return null;
    }

    @Override
    public Admin getAdminByIncident(String id) {
        try{
            String postal= getPostalByIncidentId(id);
            Location location= locationdao.findById(postal).get();
            return location.getAdmin();
        }
        catch (Exception e){
            throw new NoSuchElementException("invalid incident id");
        }



    }

    @Override
    public List<Temporarydatabaseofincident> getAllActiveIncident() throws EmptyListException {
        try{
            List<Temporarydatabaseofincident> temporarydatabaseofincidents= temporarydatabaseofincidentdao.findAll();
            if(temporarydatabaseofincidents.size()>0) return temporarydatabaseofincidents;
            else throw new EmptyListException("No  Active Incidents Found");
        }catch(Exception exc){
            throw new EmptyListException("No Active Incidents Found");
        }

    }

    @Override
    public List<Centralrepositoryofincident> getAllIncidentHappens() throws EmptyListException {
        List<Centralrepositoryofincident> centralrepositoryofincidents= centralrepositoryofincidentdao.findAll();
        if(centralrepositoryofincidents.size()>0) return centralrepositoryofincidents;
        else throw new EmptyListException("No Previous Incident Found");
    }
    @Override
    public Admin getAdminOfArea(String postalcode) {
        try{
            Location location = locationdao.findById(postalcode).get();
            return location.getAdmin();
        }catch(Exception e){
            throw new NoSuchElementException("invalid postal code");
        }


    }
    @Override
    public String getPostalByUserId(String userid){
        try{
            Users user= userDao.findById(userid).get();
            List<Location> locations= locationdao.findAll();
            for(Location i : locations){
                List<Users> users= i.getUsers();
                for(Users j : users){
                    if(j.getUserid().equals(userid)) return i.getPostalcode();
                }
            }

        }catch(Exception e){
            throw new NoSuchElementException("Please enter valid userId");
        }

       return null;
    }
    @Override
    public String getPostalByIncidentId(String incidentid){
        try{
            String ans=null;
            List<Location> locations= locationdao.findAll();
            for(Location i : locations){
                List<Temporarydatabaseofincident> Incidents= i.getTemporarydatabaseofincidents();
                List<Centralrepositoryofincident> incidentss= i.getCentralrepositoryofincidentList();
                for(Temporarydatabaseofincident j : Incidents){
                    if(j.getId().equals(incidentid)) ans=i.getPostalcode();
                }
                for(Centralrepositoryofincident j : incidentss){
                    if(j.getId().equals(incidentid) ) ans= i.getPostalcode();
                }
            }
            if(ans!=null) return  ans;
            else throw new NoSuchElementException();
        }
        catch (Exception e){
            throw new NoSuchElementException("Please provide valid incidentId");
        }


    }

    @Override
    public String getPostalByAdminId(String adminid){
        try {
            Admin admin1 = adminDao.findById(adminid).get();
            List<Location> locations = locationdao.findAll();
            for (Location i : locations) {
                Admin admin = i.getAdmin();
                String id = admin.getAdminid();
                if (id.equals(adminid)) {
                    return i.getPostalcode();
                }
            }
        }
        catch(Exception exc){
            throw new NoSuchElementException("enter valid adminId");
        }
        return null;
    }
    @Override
    public Temporarydatabaseofincident addOrganisation(String id) {
        return null;
    }

    @Override
    public Centralrepositoryofincident incidentEnd(String incidentId, LocalDate endDate) {
        try{
            Temporarydatabaseofincident incident=temporarydatabaseofincidentdao.findById(incidentId).get();
            incident.setIncidentEndDate(endDate);
            temporarydatabaseofincidentdao.save(incident);
            Location location = locationdao.findById(getPostalByIncidentId(incidentId)).get();
            Users user = getUserByIncidentInLocal(incidentId);

            List<Temporarydatabaseofincident> locincidents= location.getTemporarydatabaseofincidents();
            locincidents.remove(incident);

            List<Temporarydatabaseofincident> userincide=user.getTemporarydatabaseofincidents();
            userincide.remove(incident);


            Centralrepositoryofincident centralrepositoryofincident = new Centralrepositoryofincident();
            centralrepositoryofincident.setId(incident.id);
            centralrepositoryofincident.setName(incident.getName());
            centralrepositoryofincident.setIncidentEndDate(incident.getIncidentEndDate());
            centralrepositoryofincident.setDistrict(incident.getDistrict());
            centralrepositoryofincident.setCasualty(incident.getCasualty());
            centralrepositoryofincident.setDescription(incident.getDescription());
            centralrepositoryofincident.setIncidentDate(incident.getIncidentDate());
            centralrepositoryofincident.setState(incident.getState());
            List<Centralrepositoryofincident> locationincidents= location.getCentralrepositoryofincidentList();
            locationincidents.add(centralrepositoryofincident);
            List<Centralrepositoryofincident> userincidents= user.getCentralrepositoryofincidents();
            userincidents.add(centralrepositoryofincident);
            locationincidents.add(centralrepositoryofincident);
            temporarydatabaseofincidentdao.delete(incident);
            centralrepositoryofincidentdao.save(centralrepositoryofincident);

            return centralrepositoryofincident;

        }
        catch(Exception e){
            throw new NoSuchElementException("invalid incidentId");
        }
    }
    public List<Centralrepositoryofincident> findIncidentsBetweenDuration() {
        return null;
    }

    @Override
    public long updateCasuality(String incidentid, long Casuality) {
        try{
            Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentid).get();

            incident.setCasualty(incident.getCasualty()+Casuality);
            temporarydatabaseofincidentdao.save(incident);
            return incident.getCasualty();
        }
        catch(Exception e){
            throw new NoSuchElementException("no incident found with id");
        }



    }

    public Users getUserByIncidentInLocal(String incidentid)throws NoSuchElementException{
        try{
            Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentid).get();
            Location location = locationdao.findById(getPostalByIncidentId(incidentid)).get();
            List<Users> users = location.getUsers();
            for( Users i : users){
                List<Temporarydatabaseofincident> incidents= i.getTemporarydatabaseofincidents();

                for( Temporarydatabaseofincident j : incidents){
                    if(j.getId().equals(incidentid)) return i;
                }

            }
        }catch(Exception e){
            throw new NoSuchElementException("please provide valid incident id");
        }
        return null;
    }
}

