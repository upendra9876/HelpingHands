package com.helpinghands.HelpingHands.repository;

import com.helpinghands.HelpingHands.entities.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.helpinghands.HelpingHands.entities.Hospital;

import java.util.List;


@Repository
public interface HospitalDao extends JpaRepository<Hospital,Integer> {


   @Query("select a from Hospital a where a.postal =:postal")
   public List<Hospital> allHospitalsInPostal(@Param("postal") String postal);

}
