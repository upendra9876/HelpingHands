package com.helpinghands.HelpingHands.services;


import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.exception.ValidIncidentidexception;
import com.helpinghands.HelpingHands.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.FloatControl;
import java.lang.invoke.WrongMethodTypeException;
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
          String postalcode= getpostalbyuserid(userId);
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
    public void Incidentverificationbyadmin(String incidentId) {
        String postal= getpostalbyincidentid(incidentId);
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
    public List<Centralrepositoryofincident> findallincidentinarea(String postalcode) throws EmptyListException {
       Location location = locationdao.findById(postalcode).get();
       if(location!=null){
           return location.getCentralrepositoryofincidentList();
       }
       else throw new EmptyListException("postal code invalid");
    }

    @Override
    public List<Object> findtotalincidentapprovebyadmin( String adminId) throws EmptyListException {
       List<Object> list= new ArrayList<>();
       String postal= getpostalbyadminid(adminId);
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
    public long totalcasualitybyincident(String incidentid) {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentid).get();
        if(incident!=null) return incident.getCasualty();
        else throw new NoSuchElementException("no incident found with id");

    }

    @Override
    public long overallcasualitiesbyincidentsinarea(String postal) {
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
    public List<Object> findallincidentraisebyuser(String userid) throws EmptyListException {
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
    public Users getuserbyincident(String incidentid){
        Centralrepositoryofincident incident = centralrepositoryofincidentdao.findById(incidentid).get();
        if(incident==null) throw new NoSuchElementException("please input valid incident id");
        Location location= locationdao.findById(getpostalbyincidentid(incidentid)).get();
        if(location!=null){
            List<Users> users = location.getUsers();
            for( Users i : users){
                List<Centralrepositoryofincident> incidents= i.getCentralrepositoryofincidents();
                for( Centralrepositoryofincident j : incidents){
                    if(j.getId().equals(incidentid)) return i;
                }
            }
        }
        return null;

    }

    @Override
    public Admin getadminbyincident(String id) {
        String postal= getpostalbyincidentid(id);
        Location location= locationdao.findById(postal).get();
        if(location!=null) {
            return location.getAdmin();
        }
        else throw new NoSuchElementException("no admin found");

    }

   @Override
    public List<Temporarydatabaseofincident> getallactiveincident() throws EmptyListException {
        List<Temporarydatabaseofincident> temporarydatabaseofincidents= temporarydatabaseofincidentdao.findAll();
        if(temporarydatabaseofincidents.size()>0){
            return temporarydatabaseofincidents;
        }
       else throw new EmptyListException("No  Active Incidents Found");
    }

    @Override
    public List<Centralrepositoryofincident> getallincidenthappens() throws EmptyListException {
        List<Centralrepositoryofincident> centralrepositoryofincidents= centralrepositoryofincidentdao.findAll();
        if(centralrepositoryofincidents.size()>0) return centralrepositoryofincidents;
        else throw new EmptyListException("No Previous Incident Found");
    }
    @Override
    public Admin getadminofarea(String postalcode) {
        Location location = locationdao.findById(postalcode).get();
        if(location!=null){
            return location.getAdmin();
        }
        else throw new NoSuchElementException("no element found");

    }
    @Override
    public String getpostalbyuserid(String userid){
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
    public String getpostalbyincidentid(String incidentid){
        List<Location> locations= locationdao.findAll();
        for(Location i : locations){
            List<Temporarydatabaseofincident> Incidents= i.getTemporarydatabaseofincidents();
            for(Temporarydatabaseofincident j : Incidents){
                if(j.getId().equals(incidentid)) return i.getPostalcode();
            }
        }
        return "no incident found";
    }

    @Override
    public String getpostalbyadminid(String adminid){
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
    public Temporarydatabaseofincident addorganisation(String id) {
        return null;
    }

    @Override
    public Temporarydatabaseofincident incidentend(String id) {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(id).get();
        if(incident!=null) {
            Date d= new Date(2023,11,23);
            incident.setIncidenteffectdate(d);
            temporarydatabaseofincidentdao.save(incident);
            return incident;
        }
        else throw new NoSuchElementException("No INcident Found with id");
    }
    public List<Centralrepositoryofincident> findincidentsbetweenduration() {
        return null;
    }


}

