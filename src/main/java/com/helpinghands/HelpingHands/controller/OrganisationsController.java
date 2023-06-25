package com.helpinghands.HelpingHands.controller;

import java.util.List;

import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1")
public class OrganisationsController {

	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private NDRFngoService ndrfNgoService;



	@Autowired
	private BloodBankService bloodBankService;
	@Autowired
	private OrganisationService organisationService;



//	@GetMapping("/getOrganisation")
//	public List<Organisation> getAllOrganisation() {
//		return this.organisationService.getAllOrganisation();
//	}
//	@GetMapping("/getHospital")
//	public List<Hospital> getAllHospital() {
//
//		return this.hospitalService.getAllHospital();
//	}
//
//	@GetMapping("/countBeds/{Id}")
//	public long getHospitalByBeds(@PathVariable int Id) {
//
//		return this.hospitalService.countBeds(Id);
//	}
//
//	@GetMapping("/availableNurse/{Id}")
//	public long getHospitalByNurse(@PathVariable int Id) {
//
//		return this.hospitalService.availableNurse(Id);
//	}
//
//	@GetMapping("/availableDoctor/{Id}")
//	public long getHospitalByDoctor(@PathVariable int Id) {
//
//		return this.hospitalService.availableDoctor(Id);
//	}
//
//	@GetMapping("/availableMediKit/{Id}")
//	public long getHospitalByMediKit(@PathVariable int Id) {
//
//		return this.hospitalService.availableMedikit(Id);
//	}
//
//	@GetMapping("/availableAmbulance/{Id}")
//	public long getHospitalByAmbulance(@PathVariable int Id) {
//
//		return this.hospitalService.availableAmbulance(Id);
//	}
//
//
//
//
//	@GetMapping("/getBloodBank")
//	public List<BloodBank> getAllBloodBank() {
//
//		return this.bloodBankService.getAllBloodBank();
//	}
//
//	@PutMapping("/{name}")
//	public ResponseEntity<Hospital> updateHospitalById(@PathVariable Integer hospitalId, @RequestParam("hospital_name") String hospital_name) {
//		Hospital updated = hospitalService.updateHospitalById(hospitalId, hospital_name);
//		return ResponseEntity.ok(updated);
//	}
//
//	@PostMapping("/NoofBeds")
//	public Hospital NoOfBeds(@RequestBody Hospital hospital) {
//		return hospitalService.AddNoofBeds(hospital);
//	}
//
//	@PostMapping("/NoOfNurse")
//	public Hospital NoofNurse(@RequestBody Hospital hospital) {
//		return hospitalService.AddNoofNurse(hospital);
//	}
//
//	@PostMapping("/NoofMedikit")
//	public Hospital NoofMedikit(@RequestBody Hospital hospital) {
//		return hospitalService.AddNoofMedikit(hospital);
//	}
//
//	@PostMapping("/NoofDoctor")
//	public Hospital NoofDoctor(@RequestBody Hospital hospital) {
//		return hospitalService.AddNoofDoctor(hospital);
//	}
//
//	@PostMapping("/NoofBloodBankByCity")
//	public BloodBank BloodbankByCity(@RequestBody BloodBank bloodBank) {
//		return bloodBankService.saveBloodBankByCity(bloodBank);
//	}
//
////	@PostMapping("/NoofPerson")
////	public Relief NoofPerson(@RequestBody Relief relief) {
////		return ndrfNgoService.addNoofPerson(relief);
////	}
//
////	@PostMapping("/NoofVehicle")
////	public Relief NoofVehicle(@RequestBody Relief relief) {
////		return ndrfNgoService.addNoofVehicle(relief);
////	}
//
//	@PutMapping("/Beds/{UpdateBeds}")
//	public Hospital updateAvailableBeds(@PathVariable("hospitalId") int hospitalId, @RequestParam("beds") int available_beds) {
//		return hospitalService.updateNoOfBeds(hospitalId, available_beds);
//	}
//
//
//	@DeleteMapping("/getHospital/{HospitalId}")
//	public ResponseEntity<HttpStatus> deleteHospital(@PathVariable Integer hospitalId) {
//		try {
//			this.hospitalService.deleteHospital(hospitalId);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@DeleteMapping("/getBloodBank/{BloodBankId}")
//	public ResponseEntity<HttpStatus> deleteBloodBank(@PathVariable Long id) {
//		try {
//			this.bloodBankService.deleteBloodBank(id);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@PutMapping("/addHospitals/{incidentId}")
	public Temporarydatabaseofincident addHospitals(@PathVariable String incidentId) throws Exception{
		return this.organisationService.addHospitals(incidentId);
	}

	@PutMapping("/addReliefOrg/{incidentId}")
	public Temporarydatabaseofincident addReliefOrg(@PathVariable String incidentId) throws Exception{
		return this.organisationService.addRelief(incidentId);
	}
	@PutMapping("/Bloodbank/{incidentId}")
	public Temporarydatabaseofincident addBloodBank(@PathVariable String incidentId) throws Exception{
		return this.organisationService.addBloodbanks(incidentId);
	}

	@PostMapping("/RegisterHospital")
	public Hospital addHospital(@RequestBody Hospital hospital){
		return organisationService.registerHospital(hospital);
	}
	@PostMapping("/registerBloodBank")
	public BloodBank addBloodBank(@RequestBody BloodBank bloodBank){
		return this.organisationService.registerbloodbank(bloodBank);
	}
	@PostMapping("/RegisterRelief")
	public Relief addBloodBank(@RequestBody Relief relief){
		return this.organisationService.registerRelief(relief);
	}




}
