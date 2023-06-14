package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.TypeIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeIncidentdao extends JpaRepository<TypeIncident,String> {

}
