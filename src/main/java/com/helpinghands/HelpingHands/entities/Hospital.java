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
	private boolean hospital_available;
	private long available_doctor;
	private long available_nurse;
	private long available_beds;
	private long available_medikit;
	private long available_ambulance_available;

	@ManyToOne
	@JoinColumn(name = "hospital")
	private Organisation organisation;
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int hospitalId, String hospital_name, long available_doctor, long available_nurse,
			long available_beds, long available_medikit, long available_ambulance_available) {
		super();
		this.hospitalId = hospitalId;
		this.hospital_name = hospital_name;
		// this.hospital_available = hospital_available;
		this.available_doctor = available_doctor;
		this.available_nurse = available_nurse;
		this.available_beds = available_beds;
		this.available_medikit = available_medikit;
		this.available_ambulance_available = available_ambulance_available;
	}

	public int getHospital_id() {
		return hospitalId;
	}

	public void setHospital_id(int hospital_id) {
		this.hospitalId = hospital_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public long getAvailable_doctor() {
		return available_doctor;
	}

	public void setAvailable_doctor(long available_doctor) {
		this.available_doctor = available_doctor;
	}

	public long getAvailable_nurse() {
		return available_nurse;
	}

	public void setAvailable_nurse(long available_nurse) {
		this.available_nurse = available_nurse;
	}

	public long getAvailable_beds() {
		return available_beds;
	}

	public void setAvailable_beds(long available_beds) {
		this.available_beds = available_beds;
	}

	public long getAvailable_medikit() {
		return available_medikit;
	}

	public void setAvailable_medikit(long available_medikit) {
		this.available_medikit = available_medikit;
	}

	public long getAvailable_ambulance_available() {
		return available_ambulance_available;
	}

	public void setAvailable_ambulance_available(long available_ambulance_available) {
		this.available_ambulance_available = available_ambulance_available;
	}


}
