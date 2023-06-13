package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.Temporarydatabaseofincident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Temporarydatabaseofincidentdao extends JpaRepository<Temporarydatabaseofincident,String> {
}
