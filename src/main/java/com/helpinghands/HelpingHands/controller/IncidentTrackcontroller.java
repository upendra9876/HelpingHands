package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Centralrepositoryofincident;
import com.helpinghands.HelpingHands.entities.Temporarydatabaseofincident;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.repository.AdminDao;
import com.helpinghands.HelpingHands.repository.Centralrepositoryofincidentdao;
import com.helpinghands.HelpingHands.services.Incidenttrackservice;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Log4j2
public class IncidentTrackcontroller {
    @Autowired
    private Incidenttrackservice incidenttrackservice;

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private Centralrepositoryofincidentdao centralrepositoryofincidentdao;
    @GetMapping("/getallactiveincident")
    public List<Temporarydatabaseofincident> getallactiveincident() throws EmptyListException {
        return this.incidenttrackservice.getallactiveincident();
    }

    @GetMapping("/getallincidentsofcountry")
    public List<Centralrepositoryofincident> getallincidentofcountry() throws EmptyListException {
        return this.incidenttrackservice.getallincidenthappens();
    }
    @PostMapping("/addlocal")
    public Temporarydatabaseofincident addincident(@RequestBody Temporarydatabaseofincident incident, @RequestHeader String userId){
       return  this.incidenttrackservice.reportTheIncident(incident,userId);
    }

    @GetMapping("/verifyincident")
    public String incidentverifybyadmin(@RequestHeader String incidentId) throws NoSuchElementException {
        return this.incidenttrackservice.Incidentverificationbyadmin(incidentId);
    }
    @GetMapping("/getadmin")
    public Admin getadmin(@RequestHeader String postalcode) throws NoSuchElementException{
        return this.incidenttrackservice.getadminofarea(postalcode);
    }
    @PutMapping("/setincidentenddate")
    public Temporarydatabaseofincident endincident(@RequestHeader String incidentid) throws NoSuchElementException{
        return this.incidenttrackservice.incidentend(incidentid);
    }
    @GetMapping("/getallincidentofarea")
    public List<Centralrepositoryofincident> getallincincidentofarea(@RequestHeader String postalcode) throws EmptyListException{
        return this.incidenttrackservice.findallincidentinarea(postalcode);
    }
    @GetMapping("/findtotalincidentapprovebyadmin")
    public List<Centralrepositoryofincident> findtotalincidentapprovebyadmin(@RequestHeader String adminId) throws NoSuchElementException,EmptyListException{
        return this.incidenttrackservice.findtotalincidentapprovebyadmin(adminId);
    }




}
