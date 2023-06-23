package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class NDRFngo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long organization_id;
	private String organization_Name;
	private long available_person;
	private long available_vehicles;



	@ManyToOne
	@JoinColumn(name = "Ndrf_Ngo")
	private Organisation organisation;


    
}
