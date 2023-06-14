package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.exception.EmptyListException;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public interface Incidenttrackservice {
    public List<Temporarydatabaseofincident> getallactiveincident() throws EmptyListException;

    public List<Centralrepositoryofincident> getallincidenthappens() throws EmptyListException;

    public Location reportTheIncident(Temporarydatabaseofincident incident, String userId);//also send userid
    public void Incidentverificationbyadmin(String incidentId);

    public Admin getadminofarea(String postalcode);

    public Temporarydatabaseofincident addorganisation(String id);//List of organisation as second arguement

    public Temporarydatabaseofincident incidentend(String id);

    public List<Centralrepositoryofincident> findallincidentinarea(String postalcode) throws EmptyListException;

    public List<Object> findtotalincidentapprovebyadmin(String adminId) throws EmptyListException, NoSuchElementException;

    public List<Centralrepositoryofincident> findincidentsbetweenduration();



    public long totalcasualitybyincident(String id);

    public long overallcasualitiesbyincidentsinarea(String pincode);

    public List<Object> findallincidentraisebyuser(String id) throws EmptyListException; //id is userid


    public Users getuserbyincident(String id); //incident id and replcae return type by user
    public Admin getadminbyincident(String id); //incident id and replace return type by admin


public String getpostalbyuserid(String id);

public String getpostalbyincidentid(String id);

public String getpostalbyadminid(String adminid);



}




//15-> which user report incident from central repository.
//16-> which admin verify incident from central repository.