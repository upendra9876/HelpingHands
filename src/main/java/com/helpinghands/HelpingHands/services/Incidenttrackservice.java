package com.helpinghands.HelpingHands.services;

//import com.helpinghands.HelpingHands.dto.ReportIncident;
import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.exception.EmptyListException;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public interface Incidenttrackservice {
    public List<Temporarydatabaseofincident> getAllActiveIncident() throws EmptyListException;

    public List<Centralrepositoryofincident> getAllIncidentHappens() throws EmptyListException;

    public Location reportTheIncident(Temporarydatabaseofincident incident, String userId);//also send userid
    public void incidentVerificationByAdmin(String incidentId);

    public Admin getAdminOfArea(String postalcode);

    public Temporarydatabaseofincident addOrganisation(String id);//List of organisation as second arguement

    public Centralrepositoryofincident incidentEnd(String id, LocalDate enddate);

    public List<Centralrepositoryofincident> findAllIncidentInArea(String postalcode) throws NoSuchElementException, EmptyListException;

    public List<Object> findTotalIncidentApproveByAdmin(String adminId) throws Exception;

    public List<Centralrepositoryofincident> findIncidentsBetweenDuration();

    public long updateCasuality(String incidentid,long Casuality);



    public long totalCasualityByIncident(String id);

    public long overallCasualitiesByIncidentsInArea(String pincode);

    public List<Object> findAllIncidentRaiseByUser(String id) throws EmptyListException; //id is userid


    public Users getUserByIncident(String id); //incident id and replcae return type by user
    public Admin getAdminByIncident(String id); //incident id and replace return type by admin


public String getPostalByUserId(String id);

public String getPostalByIncidentId(String id);

public String getPostalByAdminId(String adminid);
public Users getUserByIncidentInLocal(String id);



}




//15-> which user report incident from central repository.
//16-> which admin verify incident from central repository.