package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.entities.InventoryBloodBank;
import com.helpinghands.HelpingHands.services.InventoryBloodBankService;
import com.helpinghands.HelpingHands.services.InventoryService;
import com.helpinghands.HelpingHands.services.InventoryVehicleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> getInventoryById(@PathVariable("inventoryId") String id){
        return this.inventoryService.getInventoryById(id);
    }

    @GetMapping("/inventory/vehicle")
    public ResponseEntity<Object> getAllVehicle(){
        return this.inventoryVehicleService.getAllVehicle();
    }

    @GetMapping("/inventory/vehicle/{inventoryId}")
    public ResponseEntity<Object> getAllVehicle(@PathVariable("inventoryId") String id){
        return this.inventoryVehicleService.getAllVehicle();
    }

    @GetMapping("/inventory/vehicle/{type}/{inventoryId}")
    public ResponseEntity<Object> getVehicleByType(@PathVariable("type") String vehicleType, @PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getVehicleByType(vehicleType,inventoryId);
    }

    @GetMapping("/inventory/ambulance/{inventoryId}")
    public ResponseEntity<Object> getAAmbulanceData(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getAmbulanceData(inventoryId);
    }

    @GetMapping("/inventory/blood/{inventoryId}")
    public ResponseEntity<Object> getAllBloodData(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getAllBloodData(inventoryId);
    }

    @GetMapping("/inventory/watergallon/{inventoryId}")
    public ResponseEntity<Object> getWaterGallonData(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getWaterGallon(inventoryId);
    }

    @GetMapping("/inventory/foodpacket/{inventoryId}")
    public ResponseEntity<Object> getFoodPacketData(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getFoodPacket(inventoryId);
    }

    @GetMapping("/inventory/beds/{inventoryId}")
    public ResponseEntity<Object> getBedData(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getBedData(inventoryId);
    }

    @GetMapping("/inventory/nurse/{inventoryId}")
    public ResponseEntity<Object> getNurse(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getNurseData(inventoryId);
    }

    @GetMapping("/inventory/doctors/{inventoryId}")
    public ResponseEntity<Object> getDoctors(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getDoctorsData(inventoryId);
    }

    @GetMapping("/inventory/firstaids/{inventoryId}")
    public ResponseEntity<Object> getFirstAid(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getFirstAids(inventoryId);
    }

    @GetMapping("/inventory/animalsfood/{inventoryId}")
    public ResponseEntity<Object> getAnimalsFood(@PathVariable("inventoryId") String inventoryId){
        return this.inventoryService.getAnimalsFood(inventoryId);
    }

    @PostMapping("/inventory")
    public ResponseEntity<Object> addInventory(@RequestBody Inventory newInventory){
        return this.inventoryService.addNewInventory(newInventory);
    }

    @PutMapping("/inventory/bloodbank/{inventoryId}")
    public ResponseEntity<Object> updateBloodBank(@PathVariable("inventoryId") String inventoryId,@RequestBody InventoryBloodBank inventoryBloodBank){
        return this.inventoryBloodBankService.updateBloodBank(inventoryId, inventoryBloodBank);
    }


}
