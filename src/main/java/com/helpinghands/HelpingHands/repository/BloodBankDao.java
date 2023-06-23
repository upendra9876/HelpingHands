package com.helpinghands.HelpingHands.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpinghands.HelpingHands.entities.BloodBank;

@Repository
public interface BloodBankDao extends JpaRepository<BloodBank,Long>{
	
	public BloodBank findByName(String name);

}
