package com.helpinghands.HelpingHands.controller;

import java.util.List;

import com.helpinghands.HelpingHands.entities.BloodBank;
import com.helpinghands.HelpingHands.entities.NDRFngo;
import com.helpinghands.HelpingHands.services.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.helpinghands.HelpingHands.entities.Hospital;
import com.helpinghands.HelpingHands.services.HospitalService;
import com.helpinghands.HelpingHands.services.NDRFngoService;
import com.helpinghands.HelpingHands.services.VehiclesService;
import org.springframework.http.HttpStatus;

public class OrganisationsController {
	@GetMapping
	public void chech() {
	}

	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private NDRFngoService ndrfNgoService;
	@Autowired
	private VehiclesService vehiclesService;

	@Autowired
	private BloodBankService bloodBankService;


	@GetMapping("/getHospital")
	public List<Hospital> getAllHospital() {

		return this.hospitalService.getAllHospital();
	}

	@GetMapping("/countBeds/{Id}")
	public long getHospitalByBeds(@PathVariable int Id) {

		return this.hospitalService.countBeds(Id);
	}

	@GetMapping("/availableNurse/{Id}")
	public long getHospitalByNurse(@PathVariable int Id) {

		return this.hospitalService.availableNurse(Id);
	}

	@GetMapping("/availableDoctor/{Id}")
	public long getHospitalByDoctor(@PathVariable int Id) {

		return this.hospitalService.availableDoctor(Id);
	}

	@GetMapping("/availableMediKit/{Id}")
	public long getHospitalByMediKit(@PathVariable int Id) {

		return this.hospitalService.availableMedikit(Id);
	}

	@GetMapping("/availableAmbulance/{Id}")
	public long getHospitalByAmbulance(@PathVariable int Id) {

		return this.hospitalService.availableAmbulance(Id);
	}

	@GetMapping("/availablePersonNdrf_Ngo/{Id}")
	public long getavailablePersonNdrf_Ngo(@PathVariable int Id) {
		return this.ndrfNgoService.availablePersonNdrf_Ngo(Id);
	}

	@GetMapping("/availableVehicle/{Id}")
	public long getavailableVehicle(@PathVariable int Id) {

		return this.vehiclesService.availableVehicle(Id);
	}

	@GetMapping("/getHospital")
	public List<BloodBank> getAllBloodBank() {

		return this.bloodBankService.getAllBloodBank();
	}

	@PutMapping("/{name}")
	public ResponseEntity<Hospital> updateHospitalById(@PathVariable Integer hospitalId, @RequestParam("hospital_name") String hospital_name) {
		Hospital updated = hospitalService.updateHospitalById(hospitalId, hospital_name);
		return ResponseEntity.ok(updated);
	}

	@PostMapping("/NoofBeds")
	public Hospital NoOfBeds(@RequestBody Hospital hospital) {
		return hospitalService.AddNoofBeds(hospital);
	}

	@PostMapping()
	public Hospital NoofNurse(@RequestBody Hospital hospital) {
		return hospitalService.AddNoofNurse(hospital);
	}

	@PostMapping()
	public Hospital NoofMedikit(@RequestBody Hospital hospital) {
		return hospitalService.AddNoofMedikit(hospital);
	}

	@PostMapping()
	public Hospital NoofDoctor(@RequestBody Hospital hospital) {
		return hospitalService.AddNoofDoctor(hospital);
	}

	@PostMapping()
	public BloodBank BloodbankByCity(@RequestBody BloodBank bloodBank) {
		return bloodBankService.saveBloodBankByCity(bloodBank);
	}

	@PostMapping()
	public NDRFngo NoofPerson(@RequestBody NDRFngo ndrFngo) {
		return ndrfNgoService.addNoofPerson(ndrFngo);
	}

	@PostMapping()
	public NDRFngo NoofVehicle(@RequestBody NDRFngo ndrFngo) {
		return ndrfNgoService.addNoofVehicle(ndrFngo);
	}

	@PutMapping("/Beds/{UpdateBeds}")
	public Hospital updateAvailableBeds(@PathVariable("hospitalId") int hospitalId, @RequestParam("beds") int available_beds) {
		return hospitalService.updateNoOfBeds(hospitalId, available_beds);
	}


	@DeleteMapping("/getHospital/{HospitalId}")
	public ResponseEntity<HttpStatus> deleteHospital(@PathVariable Integer hospitalId) {
		try {
			this.hospitalService.deleteHospital(hospitalId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/getBloodBank/{BloodBankId}")
	public ResponseEntity<HttpStatus> deleteBloodBank(@PathVariable Long id) {
		try {
			this.bloodBankService.deleteBloodBank(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
