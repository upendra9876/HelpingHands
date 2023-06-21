package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.Constants;
import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.repository.Temporarydatabaseofincidentdao;
import com.helpinghands.HelpingHands.services.InventoryBloodBankService;
import com.helpinghands.HelpingHands.services.InventoryService;
import com.helpinghands.HelpingHands.services.InventoryVehicleService;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RequestMapping("/api/v1")
@RestController
@Log4j2
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private InventoryBloodBankService inventoryBloodBankService;
    @Autowired
    private InventoryVehicleService inventoryVehicleService;

    @GetMapping(Constants.GET_ALL_INVENTORY)
    public ResponseEntity<Object> getAllInventory(){
        return this.inventoryService.getAllInventory();
    }
    @GetMapping(Constants.GET_INVENTORY_BY_ID)
    public Inventory getInventoryByincidentId(@PathVariable("inventoryId") String id){
        return this.inventoryService.getInventoryById(id);
    }

    @GetMapping(Constants.GET_AMBULANCE_USED_IN_INCIDENT)
    public String  getAAmbulanceData(@PathVariable String incidentId){
        return this.inventoryService.getAmbulanceData(incidentId);
    }

    @GetMapping(Constants.GET_BLOOD_USED_IN_INCIDENT)
    public String getAllBloodData(@PathVariable String incidentId){
        return this.inventoryService.getAllBloodData(incidentId);
    }

    @GetMapping(Constants.GET_WATERGALLONS_USED_IN_INCIDENT)
    public String getWaterGallonData(@PathVariable String incidentId){
        return this.inventoryService.getWaterGallon(incidentId);
    }

    @GetMapping(Constants.GET_FOODPACKETS_USED_IN_INCIDENT)
    public String getFoodPacketData(@PathVariable String incidentId){
        return this.inventoryService.getFoodPacket(incidentId);
    }

    @GetMapping(Constants.GET_BEDS_USED_IN_INCIDENT)
    public String getBedData(@PathVariable String incidentId){
        return this.inventoryService.getBedData(incidentId);
    }

    @GetMapping(Constants.GET_NURSE_POSTED_IN_INCIDENT)
    public String getNurse(@PathVariable String incidentId){
        return this.inventoryService.getNurseData(incidentId);
    }

    @GetMapping(Constants.GET_DOCTOR_POSTED_IN_INCIDENT)
    public String getDoctors(@PathVariable String incidentId){
        return this.inventoryService.getDoctorsData(incidentId);
    }

    @GetMapping(Constants.GET_FIRSTAIDS_USED_IN_INCIDENT)
    public String getFirstAid(@PathVariable String incidentId){
        return this.inventoryService.getFirstAids(incidentId);
    }

    @GetMapping(Constants.GET_ANIMALFOOD_USED_IN_INCIDENT)
    public String getAnimalsFood(@PathVariable String incidentId){
        return this.inventoryService.getAnimalsFood(incidentId);
    }

    @PostMapping(Constants.ADD_INVENTORY_TO_INCIDENT)
    public Temporarydatabaseofincident addInventoryToIncident(@PathVariable String incidentId , @RequestBody Inventory newInventory){
        return  this.inventoryService.addInventoryToIncident(incidentId, newInventory);
    }

    @PutMapping(Constants.UPDATE_BLOOD_DEPOSIT_FOR_INCIDENT)
    public InventoryBloodBank updateBloodBankForIncident(@PathVariable String incidentId, @RequestBody InventoryBloodBank inventoryBloodBank) throws NoSuchElementException{
        return this.inventoryBloodBankService.updateBloodBank(incidentId,inventoryBloodBank);
    }

    @GetMapping(Constants.GET_COUNT_OF_VEHICLES_USED_INCIDENT)
    public InventoryVehicle geCountOfVehicleUsedInIncident(@PathVariable String incidentId) throws NoSuchElementException{
        return this.inventoryVehicleService.getAllVehicleUsedInIncident(incidentId);
    }

    @PutMapping(Constants.UPDATE_VEHICLE_COUNT_FOR_INCIDENT)
    public InventoryVehicle updateVehicleForIncident(@PathVariable String incidentId, @RequestBody InventoryVehicle vehicle) throws NoSuchElementException {
        return this.inventoryVehicleService.updateVehicleCountForIncident(incidentId,vehicle);
    }

    @PutMapping(Constants.UPDATE_WATER_GALLON_FOR_INCIDENT)
    public String updateWaterGallon(@PathVariable String incidentId, long waterGallon) throws NoSuchElementException{
    return this.inventoryService.updateWaterGallon(incidentId,waterGallon);
    }
    @PutMapping(Constants.UPDATE_FOODPACKETS_FOR_INCIDENT)
    public String  updateFoodPacket(@PathVariable String incidentId, long foodPacket)throws NoSuchElementException{
    return this.inventoryService.updateFoodPacket(incidentId,foodPacket);
    }
    @PutMapping(Constants.UPDATE_FIRSTAID_FOR_INCIDENT)
    public String updateFirstAids(@PathVariable String incidentId, long firstAids)throws NoSuchElementException{
        return this.inventoryService.updateFirstAids(incidentId, firstAids);

    }
    @PutMapping(Constants.UPDATE_DOCTOR_COUNT_FOR_INCIDENT)
    public String updateDoctors(@PathVariable String incidentId, long doctors)throws NoSuchElementException{
        return this.inventoryService.updateDoctor(incidentId,doctors);
    }
    @PutMapping(Constants.UPDATE_NURSE_COUNT_FOR_INCIDENT)
    public String updateNurse(@PathVariable String incidentId, long nurse)throws NoSuchElementException{
        return this.inventoryService.updateNurse(incidentId,nurse);
    }
    @PutMapping(Constants.UPDATE_ANIMALFOOD_FOR_INCIDENT)
    public String updateAnimalFoods(@PathVariable String incidentId, long animalFoods)throws NoSuchElementException{
        return this.inventoryService.updateAnimalFoods(incidentId,animalFoods);
    }
    @PutMapping(Constants.UPDATE_AMBULANCE_FOR_INCIDENT)
    public String updateAmbulance(@PathVariable String incidentId, long ambulance)throws NoSuchElementException{
        return this.inventoryService.updateAmbulance(incidentId,ambulance);
    }
    @PutMapping(Constants.UPDATE_BEDS_FOR_INCIDENT)
    public String updateBeds(@PathVariable String incidentId, long beds)throws NoSuchElementException{
        return this.inventoryService.updateBeds(incidentId,beds);
    }


}
