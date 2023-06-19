package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.entities.*;
import com.helpinghands.HelpingHands.repository.Temporarydatabaseofincidentdao;
import com.helpinghands.HelpingHands.services.InventoryBloodBankService;
import com.helpinghands.HelpingHands.services.InventoryService;
import com.helpinghands.HelpingHands.services.InventoryVehicleService;
import lombok.extern.log4j.Log4j2;
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

    @GetMapping("/inventory")
    public ResponseEntity<Object> getAllInventory(){
        return this.inventoryService.getAllInventory();
    }
    @GetMapping("/inventory/{inventoryId}")
    public Inventory getInventoryByincidentId(@PathVariable("inventoryId") String id){
        return this.inventoryService.getInventoryById(id);
    }



    @GetMapping("/inventory/vehicle/{type}/{inventoryId}")
    public ResponseEntity<Object> getVehicleByType(@PathVariable("type") String vehicleType, @PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getVehicleByType(vehicleType,inventoryId);
    }

    @GetMapping("/inventory/ambulance/{incidentId}")
    public String  getAAmbulanceData(@PathVariable String incidentId){
        return this.inventoryService.getAmbulanceData(incidentId);
    }

    @GetMapping("/inventory/blood/{incidentId}")
    public String getAllBloodData(@PathVariable String incidentId){
        return this.inventoryService.getAllBloodData(incidentId);
    }

    @GetMapping("/inventory/watergallon/{incidentId}")
    public String getWaterGallonData(@PathVariable String incidentId){
        return this.inventoryService.getWaterGallon(incidentId);
    }

    @GetMapping("/inventory/foodpacket/{incidentId}")
    public String getFoodPacketData(@PathVariable String incidentId){
        return this.inventoryService.getFoodPacket(incidentId);
    }

    @GetMapping("/inventory/beds/{incidentId}")
    public String getBedData(@PathVariable String incidentId){
        return this.inventoryService.getBedData(incidentId);
    }

    @GetMapping("/inventory/nurse/{incidentId}")
    public String getNurse(@PathVariable String incidentId){
        return this.inventoryService.getNurseData(incidentId);
    }

    @GetMapping("/inventory/doctors/{incidentId}")
    public String getDoctors(@PathVariable String incidentId){
        return this.inventoryService.getDoctorsData(incidentId);
    }

    @GetMapping("/inventory/firstaids/{incidentId}")
    public String getFirstAid(@PathVariable String incidentId){
        return this.inventoryService.getFirstAids(incidentId);
    }

    @GetMapping("/inventory/animalsfood/{incidentId}")
    public String getAnimalsFood(@PathVariable String incidentId){
        return this.inventoryService.getAnimalsFood(incidentId);
    }

    @PostMapping("/addInventoryToIncident/{incidentId}")
    public Temporarydatabaseofincident addInventoryToIncident(@PathVariable String incidentId , @RequestBody Inventory newInventory){
        return  this.inventoryService.addInventoryToIncident(incidentId, newInventory);
    }

    @PutMapping("updateBloodBankForIncident/{incidentId}")
    public InventoryBloodBank updateBloodBankForIncident(@PathVariable String incidentId, @RequestBody InventoryBloodBank inventoryBloodBank) throws NoSuchElementException{
        return this.inventoryBloodBankService.updateBloodBank(incidentId,inventoryBloodBank);
    }

    @GetMapping("/getCountOfVehicleUsedInIncident/{incidentId}")
    public InventoryVehicle geCountOfVehicleUsedInIncident(@PathVariable String incidentId) throws NoSuchElementException{
        return this.inventoryVehicleService.getAllVehicleUsedInIncident(incidentId);
    }

    @PutMapping("/updateVehicleForIncident/{incidentId}")
    public InventoryVehicle updateVehicleForIncident(@PathVariable String incidentId, @RequestBody InventoryVehicle vehicle) throws NoSuchElementException {
        return this.inventoryVehicleService.updateVehicleCountForIncident(incidentId,vehicle);
    }

    @PutMapping("/updateWaterGallonForIncident/{incidentId}")
    public String updateWaterGallon(@PathVariable String incidentId, long waterGallon) throws NoSuchElementException{
    return this.inventoryService.updateWaterGallon(incidentId,waterGallon);
    }
    @PutMapping("/updateFoodPacketForIncident/{incidentId}")
    public String  updateFoodPacket(@PathVariable String incidentId, long foodPacket)throws NoSuchElementException{
    return this.inventoryService.updateFoodPacket(incidentId,foodPacket);
    }
    @PutMapping("/updateFirstAidsForIncident/{incidentId}")
    public String updateFirstAids(@PathVariable String incidentId, long firstAids)throws NoSuchElementException{
        return this.inventoryService.updateFirstAids(incidentId, firstAids);

    }
    @PutMapping("/updateDoctorForIncident/{incidentId}")
    public String updateDoctors(@PathVariable String incidentId, long doctors)throws NoSuchElementException{
        return this.inventoryService.updateDoctor(incidentId,doctors);
    }
    @PutMapping("/updateNurseForIncident/{incidentId}")
    public String updateNurse(@PathVariable String incidentId, long nurse)throws NoSuchElementException{
        return this.inventoryService.updateNurse(incidentId,nurse);
    }
    @PutMapping("/updateAnimalFoodForIncident/{incidentId}")
    public String updateAnimalFoods(@PathVariable String incidentId, long animalFoods)throws NoSuchElementException{
        return this.inventoryService.updateAnimalFoods(incidentId,animalFoods);
    }
    @PutMapping("/updateAmbulanceForIncident/{incidentId}")
    public String updateAmbulance(@PathVariable String incidentId, long ambulance)throws NoSuchElementException{
        return this.inventoryService.updateAmbulance(incidentId,ambulance);
    }
    @PutMapping("/updateBedsForIncident/{incidentId}")
    public String updateBeds(@PathVariable String incidentId, long beds)throws NoSuchElementException{
        return this.inventoryService.updateBeds(incidentId,beds);
    }


}
