package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.Admin;
import com.helpinghands.HelpingHands.entities.Centralrepositoryofincident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Centralrepositoryofincidentdao extends JpaRepository<Centralrepositoryofincident,String> {

    @Query("Select u from Centralrepositoryofincident u where u.postalcode =:postalcode")
    public List<Centralrepositoryofincident> getallincidentsofarea(@Param("postalcode") String postalcode);
}
