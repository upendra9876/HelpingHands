package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Centralrepositoryofincident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Centralrepositoryofincidentdao extends JpaRepository<Centralrepositoryofincident,String> {

    @Query("select a from Centralrepositoryofincident a where a.incidentDate >= :incidentDate")
    List<Centralrepositoryofincident> getallincidentafterdate(@Param("incidentDate")LocalDate incidentDate);

    @Query("select a FROM Centralrepositoryofincident a WHERE a.incidentDate BETWEEN :startdate AND :enddate")
    List<Centralrepositoryofincident> getallincidentbetweendate(@Param("startdate") LocalDate startdate, @Param("enddate") LocalDate enddate);





}
