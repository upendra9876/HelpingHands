package com.helpinghands.HelpingHands.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpinghands.HelpingHands.entities.Vehicles;

@Repository
public interface VehiclesDao  extends JpaRepository<Vehicles,Long>{

}
