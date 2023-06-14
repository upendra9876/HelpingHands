package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.repository.AdminDao;
import com.helpinghands.HelpingHands.repository.Centralrepositoryofincidentdao;
import com.helpinghands.HelpingHands.services.Incidenttrackservice;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    @GetMapping("/totalcasualitybyincident/{incidentid}")
    public long totalcasualitybyincident(@PathVariable String incidentid){
        return this.incidenttrackservice.totalcasualitybyincident(incidentid);
    }

    @GetMapping("/getallincidentsofcountry")
    public List<Centralrepositoryofincident> getallincidentofcountry() throws EmptyListException {
        return this.incidenttrackservice.getallincidenthappens();
    }
    @PostMapping("/addlocal")
    public Location addincident(@RequestBody Temporarydatabaseofincident incident, @RequestHeader String userId){
       return  this.incidenttrackservice.reportTheIncident(incident,userId);
    }

    @GetMapping("/verifyincident")
    public String incidentverifybyadmin(@RequestHeader String incidentId) throws NoSuchElementException {
        this.incidenttrackservice.Incidentverificationbyadmin(incidentId);
        return "incident verified by admin";
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
    public List<Object> findtotalincidentapprovebyadmin(@RequestHeader String adminId) throws NoSuchElementException,EmptyListException{
        return this.incidenttrackservice.findtotalincidentapprovebyadmin(adminId);
    }

    @GetMapping("/getpostalbyuser/{userId}")
    public String getpostalbyuser(@PathVariable String userId){
        return incidenttrackservice.getpostalbyuserid(userId);
    }

    @GetMapping("/getpostalbyincidentid/{incidentid}")
    public String getpostalbyincidentid(@PathVariable String incidentid){
        return this.incidenttrackservice.getpostalbyincidentid(incidentid);
    }

    @GetMapping("/getpostalbyadminid")
    public String getpostalbyadminid(@RequestHeader String adminid){
        return this.incidenttrackservice.getpostalbyadminid(adminid);
    }
    @GetMapping("/overallcasualitiesinarea/{postal}")
    public long overallcasualityinarea(@PathVariable String postal){
        return this.incidenttrackservice.overallcasualitiesbyincidentsinarea(postal);
    }
    @GetMapping("/findallincidentraisebyuser")
    public List<Object> findallincidentraisebyuser(@RequestHeader String userid) throws EmptyListException{
        return  this.incidenttrackservice.findallincidentraisebyuser(userid);
    }
    @GetMapping("/getadminbyincident")
    public Admin getadminbyincident(@RequestHeader String incidentid){
        return this.incidenttrackservice.getadminbyincident(incidentid);
    }
    @GetMapping("/getuserbyincident")
    public Users getuserbyincident(@RequestHeader String incidentid){
        return this.incidenttrackservice.getuserbyincident(incidentid);

    }

}
