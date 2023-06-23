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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicle_id;
	private String vehicle_type;
	private long available_vehicle;
	public Vehicles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicles(long vehicle_id, String vehicle_type, long available_vehicle) {
		super();
		this.vehicle_id = vehicle_id;
		this.vehicle_type = vehicle_type;
		this.available_vehicle = available_vehicle;
	}
	public long getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public long getAvailable_vehicle() {
		return available_vehicle;
	}
	public void setAvailable_vehicle(long available_vehicle) {
		this.available_vehicle = available_vehicle;
	}
	
	
}
