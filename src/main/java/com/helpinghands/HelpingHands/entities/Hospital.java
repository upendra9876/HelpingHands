package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="HospitalDetails")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;

	private String hospital_name;


	private long available_doctor;

	private long available_nurse;

	private long available_beds;

	private long available_medikit;

	private long available_ambulance_available;

	private String postal;





}
