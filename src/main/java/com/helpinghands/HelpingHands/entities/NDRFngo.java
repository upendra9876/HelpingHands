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

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Vehicles.class)
    @JoinColumn(name = "Type")
    private List<Vehicles> vehicles;

	@ManyToOne
	@JoinColumn(name = "Ndrf_Ngo")
	private Organisation organisation;

	public NDRFngo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NDRFngo(long organization_id, String organization_Name, long available_person, long available_vehicles,
			List<Vehicles> vehicles) {
		super();
		this.organization_id = organization_id;
		this.organization_Name = organization_Name;
		this.available_person = available_person;
		this.available_vehicles = available_vehicles;
		this.vehicles = vehicles;
	}

	public long getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(long organization_id) {
		this.organization_id = organization_id;
	}

	public String getOrganization_Name() {
		return organization_Name;
	}

	public void setOrganization_Name(String organization_Name) {
		this.organization_Name = organization_Name;
	}

	public long getAvailable_person() {
		return available_person;
	}

	public void setAvailable_person(long available_person) {
		this.available_person = available_person;
	}

	public long getAvailable_vehicles() {
		return available_vehicles;
	}

	public void setAvailable_vehicles(long available_vehicles) {
		this.available_vehicles = available_vehicles;
	}

	public List<Vehicles> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}
    
    
}
