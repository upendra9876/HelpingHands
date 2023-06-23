package com.helpinghands.HelpingHands.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpinghands.HelpingHands.entities.Vehicles;
import com.helpinghands.HelpingHands.repository.VehiclesDao;

@Service
public class VehiclesService {
	
	@Autowired
	private VehiclesDao vehiclesDao;
	
	public long availableVehicle(long id) {
		Vehicles vehicle = vehiclesDao.findById(id).get();
		long availablevehicle = vehicle.getAvailable_vehicle();
		return availablevehicle;
	}

}
