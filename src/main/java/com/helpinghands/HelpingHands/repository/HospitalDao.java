package com.helpinghands.HelpingHands.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpinghands.HelpingHands.entities.Hospital;


@Repository
public interface HospitalDao extends JpaRepository<Hospital,Integer> {

   // Hospital updateHospitalById(Integer hospitalId, String hospital_name);

}
