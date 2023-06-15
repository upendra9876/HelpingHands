package com.helpinghands.HelpingHands.services;


import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.exception.ValidIncidentidexception;
import com.helpinghands.HelpingHands.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Location reportTheIncident(Temporarydatabaseofincident incident,String userId) {
        Users user= userDao.findById(userId).get();
        String error="NO USer exist with id"+userId;
        if(user!=null){
            String postalcode= getPostalByUserId(userId);
            Location location= locationdao.findById(postalcode).get();
            List<Temporarydatabaseofincident> incidents= location.getTemporarydatabaseofincidents();
            List<Temporarydatabaseofincident> userincident= user.getTemporarydatabaseofincidents();
            temporarydatabaseofincidentdao.save(incident);
            userincident.add(incident);
            incidents.add(incident);
            locationdao.save(location);
            return location;
        }
        else throw new NoSuchElementException(error);

    }


    @Override
    public void incidentVerificationByAdmin(String incidentId) {
        String postal= getPostalByIncidentId(incidentId);
        Location location = locationdao.findById(postal).get();
        if(location!=null){
            location.setTotaldisaster(location.getTotaldisaster()+1);
            Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();
            locationdao.save(location);
            incident.setStatus(true);
            temporarydatabaseofincidentdao.save(incident);
        }
        else throw new NoSuchElementException("no value present");

    }

    @Override
    public List<Centralrepositoryofincident> findAllIncidentInArea(String postalcode) throws EmptyListException {
        Location location = locationdao.findById(postalcode).get();
        if(location!=null){
            return location.getCentralrepositoryofincidentList();
        }
        else throw new EmptyListException("postal code invalid");
    }

    @Override
    public List<Object> findTotalIncidentApproveByAdmin( String adminId) throws EmptyListException {
        List<Object> list= new ArrayList<>();
        String postal= getPostalByAdminId(adminId);
        Location location= locationdao.findById(postal).get();
        if(location!=null){
            List<Centralrepositoryofincident> list1= location.getCentralrepositoryofincidentList();
            for(Centralrepositoryofincident i : list1){
                list.add(i);
            }
            List<Temporarydatabaseofincident> list2 = location.getTemporarydatabaseofincidents();
            for( Temporarydatabaseofincident j : list2){
                if(j.isStatus()) list.add(j);
            }

        }
        if(list.size()>0) return list;
        else throw new EmptyListException("no incident verify by admin");
    }


    @Override
    public long totalCasualityByIncident(String incidentid) {
        Centralrepositoryofincident incident= centralrepositoryofincidentdao.findById(incidentid).get();
        if(incident!=null) return incident.getCasualty();
        else throw new NoSuchElementException("no incident found with id");

    }

    @Override
    public long overallCasualitiesByIncidentsInArea(String postal) {
        Location location= locationdao.findById(postal).get();
        if(location!=null) {
            long totalcasuality=0;
            List<Centralrepositoryofincident> incidents= location.getCentralrepositoryofincidentList();
            for( Centralrepositoryofincident i : incidents){
                totalcasuality=totalcasuality+i.getCasualty();

            }
            return totalcasuality;
        }
        else throw new NoSuchElementException("invalid postal code");

    }

    @Override
    public List<Object> findAllIncidentRaiseByUser(String userid) throws EmptyListException {
        List<Object> answerlist= new ArrayList<>();
        Users user= userDao.findById(userid).get();
        if(user!=null){
            List<Centralrepositoryofincident> incidents= user.getCentralrepositoryofincidents();
            List<Temporarydatabaseofincident> incidentss= user.getTemporarydatabaseofincidents();
            for( Centralrepositoryofincident i : incidents) answerlist.add(i);
            for(Temporarydatabaseofincident i : incidentss) answerlist.add(i);
            if(answerlist.size()>0) return answerlist;
            else throw new EmptyListException("user has not raise any incident");
        }
        else throw new NoSuchElementException("no user found with id");

    }

    // temporaryincident
    @Override
    public Users getUserByIncident(String incidentid){

        Centralrepositoryofincident incident = centralrepositoryofincidentdao.findById(incidentid).get();
        if(incident!=null){
            Location location = locationdao.findById(getPostalByIncidentId(incidentid)).get();
            if(location!=null){
                List<Users> users = location.getUsers();
                for( Users i : users){
                    List<Centralrepositoryofincident> incidents= i.getCentralrepositoryofincidents();

                    for( Centralrepositoryofincident j : incidents){
                        if(j.getId().equals(incidentid)) return i;
                    }

                }
            }
        }
        else throw new NoSuchElementException("please provide valid incident id");
        return null;

    }

    @Override
    public Admin getAdminByIncident(String id) {
        String postal= getPostalByIncidentId(id);
        Location location= locationdao.findById(postal).get();
        if(location!=null) {
            return location.getAdmin();
        }
        else throw new NoSuchElementException("no admin found");

    }

    @Override
    public List<Temporarydatabaseofincident> getAllActiveIncident() throws EmptyListException {
        List<Temporarydatabaseofincident> temporarydatabaseofincidents= temporarydatabaseofincidentdao.findAll();
        if(temporarydatabaseofincidents.size()>0){
            return temporarydatabaseofincidents;
        }
        else throw new EmptyListException("No  Active Incidents Found");
    }

    @Override
    public List<Centralrepositoryofincident> getAllIncidentHappens() throws EmptyListException {
        List<Centralrepositoryofincident> centralrepositoryofincidents= centralrepositoryofincidentdao.findAll();
        if(centralrepositoryofincidents.size()>0) return centralrepositoryofincidents;
        else throw new EmptyListException("No Previous Incident Found");
    }
    @Override
    public Admin getAdminOfArea(String postalcode) {
        Location location = locationdao.findById(postalcode).get();
        if(location!=null){
            return location.getAdmin();
        }
        else throw new NoSuchElementException("no element found");

    }
    @Override
    public String getPostalByUserId(String userid){
        List<Location> locations= locationdao.findAll();
        for(Location i : locations){
            List<Users> users= i.getUsers();
            for(Users j : users){
                if(j.getUserid().equals(userid)) return i.getPostalcode();
            }
        }
        return "no user found";
    }
    @Override
    public String getPostalByIncidentId(String incidentid){
        List<Location> locations= locationdao.findAll();
        for(Location i : locations){
            List<Temporarydatabaseofincident> Incidents= i.getTemporarydatabaseofincidents();
            List<Centralrepositoryofincident> incidentss= i.getCentralrepositoryofincidentList();
            for(Temporarydatabaseofincident j : Incidents){
                if(j.getId().equals(incidentid)) return i.getPostalcode();
            }
            for(Centralrepositoryofincident j : incidentss){
                if(j.getId().equals(incidentid) ) return i.getPostalcode();
            }
        }
        return "no incident found";
    }

    @Override
    public String getPostalByAdminId(String adminid){
        List<Location> locations= locationdao.findAll();
        for(Location i : locations){
            Admin admin= i.getAdmin();
            String id= admin.getId();
            if(id.equals(adminid)){
                return i.getPostalcode();
            }

        }
        return "no postal found for admin id";
    }
    @Override
    public Temporarydatabaseofincident addOrganisation(String id) {
        return null;
    }

    @Override
    public Centralrepositoryofincident incidentEnd(String incidentid, LocalDate enddate) {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentid).get();

        if(incident!=null) {
            incident.setIncidentEndDate(enddate);
            Location location = locationdao.findById(getPostalByIncidentId(incidentid)).get();
            Users user = getUserByIncidentInLocal(incidentid);
            List<Centralrepositoryofincident> centralrepositoryofincidents= location.getCentralrepositoryofincidentList();
            List<Centralrepositoryofincident> centralrepositoryofincidentList= user.getCentralrepositoryofincidents();
            List<Temporarydatabaseofincident> temporarydatabaseofincidents= location.getTemporarydatabaseofincidents();
            temporarydatabaseofincidents.remove(incident);
            List<Temporarydatabaseofincident> temporarydatabaseofincidents1= user.getTemporarydatabaseofincidents();
            temporarydatabaseofincidents1.remove(incident);
            temporarydatabaseofincidentdao.delete(incident);
            Centralrepositoryofincident centralrepositoryofincident= new Centralrepositoryofincident();

            centralrepositoryofincident.setId(incident.id);
            centralrepositoryofincident.setName(incident.getName());
            centralrepositoryofincident.setIncidentEndDate(incident.getIncidentEndDate());
            centralrepositoryofincident.setDistrict(incident.getDistrict());
            centralrepositoryofincident.setCasualty(incident.getCasualty());
            centralrepositoryofincident.setDescription(incident.getDescription());
            centralrepositoryofincident.setIncidentDate(incident.getIncidentDate());
            centralrepositoryofincident.setIncidenttime(incident.getIncidenttime());
            centralrepositoryofincident.setState(incident.getState());
            centralrepositoryofincidentdao.save(centralrepositoryofincident);

            centralrepositoryofincidentList.add(centralrepositoryofincident);
            centralrepositoryofincidents.add(centralrepositoryofincident);
            locationdao.save(location);

            return centralrepositoryofincident;

        }
        else throw new NoSuchElementException("No INcident Found with id");
    }
    public List<Centralrepositoryofincident> findIncidentsBetweenDuration() {
        return null;
    }

    @Override
    public long updateCasuality(String incidentid, long Casuality) {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentid).get();
        if(incident!=null) {
            incident.setCasualty(incident.getCasualty()+Casuality);
            temporarydatabaseofincidentdao.save(incident);
            return incident.getCasualty();
        }
        else throw new NoSuchElementException("no incident found with id");
    }

    public Users getUserByIncidentInLocal(String incidentid){

        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentid).get();
        if(incident!=null){
            Location location = locationdao.findById(getPostalByIncidentId(incidentid)).get();
            if(location!=null){
                List<Users> users = location.getUsers();
                for( Users i : users){
                    List<Temporarydatabaseofincident> incidents= i.getTemporarydatabaseofincidents();

                    for( Temporarydatabaseofincident j : incidents){
                        if(j.getId().equals(incidentid)) return i;
                    }

                }
            }
        }
        else throw new NoSuchElementException("please provide valid incident id");
        return null;

    }



}

