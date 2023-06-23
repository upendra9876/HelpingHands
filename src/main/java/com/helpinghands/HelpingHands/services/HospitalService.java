package com.helpinghands.HelpingHands.services;

import java.util.List;

import com.helpinghands.HelpingHands.entities.BloodBank;
import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpinghands.HelpingHands.entities.Hospital;
import com.helpinghands.HelpingHands.repository.HospitalDao;
import org.webjars.NotFoundException;


@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao hospitalDao;
	
	public HospitalService(HospitalDao hospitalDao) {
		super();
		this.hospitalDao = hospitalDao;
	}

	public List<Hospital> getAllHospital() {
		return hospitalDao.findAll();
	}
	
	public long countBeds(int id) {
		Hospital hospital = hospitalDao.findById(id).get();
		long beds = hospital.getAvailable_beds();
		return beds;
		
	}
	
	public long availableNurse(int id) {
		Hospital hospital = hospitalDao.findById(id).get();
		long nurse = hospital.getAvailable_nurse();
		return nurse;
	}
	
	public long availableDoctor(int id) {
		Hospital hospital = hospitalDao.findById(id).get();
		long doctor = hospital.getAvailable_doctor();
		return doctor;
	}
	
	public long availableMedikit(int id) {
		Hospital hospital = hospitalDao.findById(id).get();
		long mediKit = hospital.getAvailable_medikit();
		return mediKit;
	}
	
	public long availableAmbulance(int id) {
		Hospital hospital = hospitalDao.findById(id).get();
		long ambulance= hospital.getAvailable_ambulance_available();
		return ambulance;
	}
	public Hospital AddNoofBeds(Hospital hospital)
	{
		return hospitalDao.save(hospital);
	}

	public Hospital AddNoofNurse(Hospital hospital)
	{
		return hospitalDao.save(hospital);
	}

	public Hospital AddNoofMedikit(Hospital hospital)
	{
		return  hospitalDao.save(hospital);
	}

	public Hospital AddNoofDoctor(Hospital hospital)
	{
		return  hospitalDao.save(hospital);
	}

	public Hospital updateNoOfBeds(int hospitalId, int available_beds)
	{
		Hospital hospital = hospitalDao.findById(hospitalId).orElse(null);
		if(hospital!=null)
		{
			hospital.setAvailable_beds(available_beds);
			return hospitalDao.save(hospital);
		}
		return null;
	}

	public Hospital updateHospitalById(Integer hospitalId, String hospital_name) {
		Hospital hospital = hospitalDao.findById(hospitalId)
				.orElseThrow(() -> new NotFoundException("Hospital not found with name: " + hospitalId));

	 hospital.setHospital_name(hospital_name);
	 hospital.setHospitalId(hospitalId);

		return hospitalDao.save(hospital);
	}

	public void deleteHospital(Integer hospitalId) {
		Hospital entity = hospitalDao.getOne(hospitalId);
		hospitalDao.delete(entity);
	}

}
