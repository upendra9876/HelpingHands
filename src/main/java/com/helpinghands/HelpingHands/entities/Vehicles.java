package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicle_id;

	private String vehicle_type;

	private long available_vehicle;




	
	
}
