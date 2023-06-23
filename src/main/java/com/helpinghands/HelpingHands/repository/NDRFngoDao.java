package com.helpinghands.HelpingHands.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpinghands.HelpingHands.entities.NDRFngo;


@Repository
public interface NDRFngoDao extends JpaRepository<NDRFngo,Long> {

}
