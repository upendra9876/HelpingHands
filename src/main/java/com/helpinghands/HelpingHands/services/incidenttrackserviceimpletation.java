package com.helpinghands.HelpingHands.services;


import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Centralrepositoryofincident;
import com.helpinghands.HelpingHands.entities.Temporarydatabaseofincident;
import com.helpinghands.HelpingHands.entities.Users;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.repository.AdminDao;
import com.helpinghands.HelpingHands.repository.Centralrepositoryofincidentdao;
import com.helpinghands.HelpingHands.repository.Temporarydatabaseofincidentdao;
import com.helpinghands.HelpingHands.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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


    @Override
    public Temporarydatabaseofincident reportTheIncident(Temporarydatabaseofincident incident,String userId) {
        Users user= userDao.findById(userId).get();
        String error="NO USer exist with id"+userId;
        if(user!=null){
            List<Temporarydatabaseofincident> incidents= user.getTemporarydatabaseofincidents();
            incidents.add(incident);
            temporarydatabaseofincidentdao.save(incident);
            userDao.save(user);
            return incident;
        }
        else throw new NoSuchElementException(error);

    }

    @Override
    public String Incidentverificationbyadmin(String incidentId) {
        Temporarydatabaseofincident incident=temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            String postalcode=incident.getPostalcode();
            Admin admin= adminDao.getadminofpostalcode(postalcode);
            if(admin!=null){
                incident.setStatus(true);
                List<Temporarydatabaseofincident> incidents= admin.getTemporarydatabaseofincidents();
                incidents.add(incident);
                temporarydatabaseofincidentdao.save(incident);
                adminDao.save(admin);
                return "Incident status is true. please add organisations";
            }else throw new NoSuchElementException("NO admin assign for postalcode");
        }else throw new NoSuchElementException("Please provide valid incidentId");


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

    @Override
    public List<Centralrepositoryofincident> findallincidentinarea(String postalcode) throws EmptyListException {
        List<Centralrepositoryofincident> incidents= centralrepositoryofincidentdao.getallincidentsofarea(postalcode);
        if(incidents.size()>0) return incidents;
        else throw new EmptyListException("no incident happen in area");
    }

    @Override
    public List<Centralrepositoryofincident> findtotalincidentapprovebyadmin( String adminId) throws EmptyListException {
        Admin admin= adminDao.findById(adminId).get();
        if(admin!=null){
            List<Centralrepositoryofincident> incidents=admin.getCentralrepositoryofincidents();
            if(incidents!=null) return incidents;
            else throw new EmptyListException("no incidents approve by admin");
        }
        else throw new NoSuchElementException("no admin found by id");
    }

    @Override
    public List<Centralrepositoryofincident> findincidentsbetweenduration() {
        return null;
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
        Admin admin=adminDao.getadminofpostalcode(postalcode);
        if(admin!=null) return admin;
        else throw new NoSuchElementException("admin of postal code is not defined");
  }
}

