package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.Constants;

import com.helpinghands.HelpingHands.dto.ReportIncident;
import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.repository.AdminDao;
import com.helpinghands.HelpingHands.repository.Centralrepositoryofincidentdao;
import com.helpinghands.HelpingHands.repository.Locationdao;
import com.helpinghands.HelpingHands.repository.Temporarydatabaseofincidentdao;
import com.helpinghands.HelpingHands.services.Incidenttrackservice;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(Constants.REQUEST_MAPPING)
@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IncidentTrackcontroller {
    @Autowired
    private Incidenttrackservice incidenttrackservice;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private Temporarydatabaseofincidentdao temporarydatabaseofincidentdao;
    @Autowired
    private Centralrepositoryofincidentdao centralrepositoryofincidentdao;

    @Autowired
    private Locationdao locationdao;
    @GetMapping(Constants.GET_ALL_INCIDENT)
    public List<Temporarydatabaseofincident> getAllActiveIncident() throws EmptyListException {
        return this.incidenttrackservice.getAllActiveIncident();
    }
    @GetMapping(Constants.TOTAL_CASULAITY_BY_INCIDENT)
    public long totalCasualityByIncident(@PathVariable String incidentId){
        return this.incidenttrackservice.totalCasualityByIncident(incidentId);
    }

    @GetMapping(Constants.GET_ALL_INCIDENT_HAPPEN)
    public List<Centralrepositoryofincident> getAllIncidentOfCountry() throws EmptyListException {
        return this.incidenttrackservice.getAllIncidentHappens();
    }
    @PostMapping(Constants.REPORT_INCIDENT)   

    public Location addIncident(@RequestBody @Valid ReportIncident incident, @RequestHeader String userId) throws Exception {

       return  this.incidenttrackservice.reportTheIncident(incident,userId);
    }

    @PutMapping(Constants.VERIFY_INCIDENT_BY_AREA_ADMIN)
    public String incidentVerifyByAdmin(@RequestHeader String incidentId) throws NoSuchElementException {
        this.incidenttrackservice.incidentVerificationByAdmin(incidentId);
        return "incident verified by admin";
    }
    @GetMapping(Constants.GET_ADMIN_OF_AREA)
    public Admin getAdmin(@RequestHeader String postalcode) throws NoSuchElementException{
        return this.incidenttrackservice.getAdminOfArea(postalcode);
    }
    @DeleteMapping(Constants.SET_INCIDENT_EFFECT_END_DATE)
    public Centralrepositoryofincident  endIncident(@RequestHeader String incidentId,@RequestHeader LocalDate endDate) throws NoSuchElementException{
      return this.incidenttrackservice.incidentEnd(incidentId,endDate);
    }
    @GetMapping(Constants.GET_ALL_INCIDENT_OF_AREA)
    public List<Centralrepositoryofincident> getAllIncincidentOfArea(@RequestHeader String postalCode) throws NoSuchElementException,EmptyListException{
        List<Centralrepositoryofincident> Incidents= this.incidenttrackservice.findAllIncidentInArea(postalCode);
        if(Incidents.size()>0 ) return Incidents;
        else throw new EmptyListException("no incident happen in area");
    }
    @GetMapping(Constants.FIND_TOTAL_INCIDENT_APPROVE_BY_ADMIN)
    public List<Object> FindTotalIncidentApproveByAdmin(@RequestHeader String adminId) throws Exception{
        return this.incidenttrackservice.findTotalIncidentApproveByAdmin(adminId);
    }

    @GetMapping(Constants.GET_POSTAL_WHICH_USER_BELONGS)
    public String getPostalByUser(@PathVariable String userId){
        return incidenttrackservice.getPostalByUserId(userId);
    }

    @GetMapping(Constants.GET_POSTAL_IN_WHICH_INCIDENT_HAPPENS)
    public String getPostalByIncidentId(@PathVariable String incidentId){
        return this.incidenttrackservice.getPostalByIncidentId(incidentId);
    }

    @GetMapping(Constants.GET_POSTAL_BY_ADMIN)
    public String getPostalByAdminId(@RequestHeader String adminId){
        return this.incidenttrackservice.getPostalByAdminId(adminId);
    }
    @GetMapping(Constants.OVERALL_CASULAITIES_IN_AREA)
    public long overallCasualityInArea(@PathVariable String postal) throws NoSuchElementException{
        return this.incidenttrackservice.overallCasualitiesByIncidentsInArea(postal);
    }
    @GetMapping(Constants.FIND_ALL_INCIDENT_RAISE_BY_USER)
    public List<Object> findAllIncidentRaiseByUser(@RequestHeader String userId) throws EmptyListException{
        return  this.incidenttrackservice.findAllIncidentRaiseByUser(userId);
    }
    @GetMapping(Constants.GET_ADMIN_WHO_APPROVE_INCIDENT)
    public Admin getAdminByIncident(@RequestHeader String incidentId){
        return this.incidenttrackservice.getAdminByIncident(incidentId);
    }
    @GetMapping(Constants.GET_USER_WHO_REPORT_INCIDENT)
    public Users getUserByIncident(@RequestHeader String incidentId){
        return this.incidenttrackservice.getUserByIncident(incidentId);

    }
    @GetMapping(Constants.GET_ALL_LOCATION)
    public List<Location> getAllLocation(){
        return locationdao.findAll();
    }

    @GetMapping(Constants.GET_ALL_INCIDENT_BETWEEN_DATE)
    public List<Centralrepositoryofincident> getAllIncidentBetweenDate(@RequestHeader LocalDate startDate, @RequestHeader LocalDate endDate){
        return centralrepositoryofincidentdao.getallincidentbetweendate(startDate,endDate);
    }

    @GetMapping(Constants.GET_ALL_INCIDENT_AFTER_DATE)
    public List<Centralrepositoryofincident> getAllIncidentAfterDate(@RequestHeader LocalDate incidentDate){
        return centralrepositoryofincidentdao.getallincidentafterdate(incidentDate);
    }
    @PutMapping(Constants.UPDATE_CASULAITY_IN_INCIDENT)
    public long updateCasuality(@PathVariable long casuality, @RequestHeader String incidentId){
        return this.incidenttrackservice.updateCasuality(incidentId,casuality);
    }
    @DeleteMapping(Constants.INCIDENT_IS_FALSE)
    public String incidentIsFalse(@PathVariable String incidentId) throws NoSuchElementException{
        Temporarydatabaseofincident incident = temporarydatabaseofincidentdao.findById(incidentId).get();

        if(incident!=null){
            temporarydatabaseofincidentdao.delete(incident);
            return "incident is false";
        }
        else throw new  NoSuchElementException("please enter valid incident id");
    }
    @GetMapping(Constants.MOST_PRONIC_AREA)
    public List<Location> mostPronicArea(){
        return this.locationdao.mostPronicToIncident();
    }

    @GetMapping(Constants.LEAST_PRONIC_AREA)
    public List<Location> leastPronicArea(){
        return this.locationdao.leastPronicAreaToIncident();
    }

    @GetMapping(Constants.GET_LOCATION_BY_POSTAL_CODE)
    public Location getLocationByPostalCode(@RequestHeader String postalCode) throws NoSuchElementException{

        Location location=locationdao.getlocationbypostalcode(postalCode);
        if(location!=null) return location;
        else throw new NoSuchElementException("please enter valid postal code");
    }

    @GetMapping(Constants.INCIDENT_WITH_MAXIMUM_CASUALTY)
    public List<Centralrepositoryofincident> getincidentwithmaxcasualty(){
        return  this.centralrepositoryofincidentdao.getincidentwithmaximumcasualty();
    }

    public Users getUserByIncidentInLocal(String id){
        return this.incidenttrackservice.getUserByIncidentInLocal(id);
    }



}
