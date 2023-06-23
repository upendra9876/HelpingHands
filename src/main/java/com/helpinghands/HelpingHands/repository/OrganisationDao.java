package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.Organisation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface OrganisationDao extends JpaRepository <Organisation, String> {

}
