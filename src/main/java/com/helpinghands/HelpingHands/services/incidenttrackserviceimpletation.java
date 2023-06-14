package com.helpinghands.HelpingHands.services;


import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.FloatControl;
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
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();
        incident.setStatus(true);
        temporarydatabaseofincidentdao.save(incident);
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
       List<Centralrepositoryofincident> list1= location.getCentralrepositoryofincidentList();
      for(Centralrepositoryofincident i : list1){
          list.add(i);
      }
      List<Temporarydatabaseofincident> list2 = location.getTemporarydatabaseofincidents();
        for( Temporarydatabaseofincident j : list2){
            if(j.isStatus()) list.add(j);
        }
        if(list.size()>0) return list;
        else throw new EmptyListException("no incident verify by admin");
    }
    @Override
    public String mostpronicareabynaturaldisaster() {
        return null;
    }

    @Override
    public String mostpronicareabymanmadedisaster() {
        return null;
    }

    @Override
    public String totalcasualitybydisaster(String id) {
        return null;
    }

    @Override
    public String overallcasualitiesbydisasterinarea(String pincode) {
        return null;
    }

    @Override
    public List<Centralrepositoryofincident> findallincidentraisebyuser(String id) {
        return null;
    }



    @Override
    public String getuserbyincident(String id) {
        return null;
    }

    @Override
    public String getadminbyincident(String id) {
        return null;
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
    public Admin getadminofarea(String postalcode){
        Admin admin=new Admin();
        if(admin!=null) return admin;
        else throw new NoSuchElementException("admin of postal code is not defined");
  }

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

