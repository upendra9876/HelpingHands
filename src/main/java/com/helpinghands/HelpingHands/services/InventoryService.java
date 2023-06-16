package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.Inventory;
import org.springframework.http.ResponseEntity;

public interface InventoryService {
    ResponseEntity<Object> getAllInventory();
    ResponseEntity<Object> getInventoryById(String id);
    ResponseEntity<Object> getVehicleByType(String vehicleType, String inventoryId);
    ResponseEntity<Object> getAmbulanceData(String inventoryId);
    ResponseEntity<Object> getWaterGallon(String inventoryId);
    ResponseEntity<Object> getFoodPacket(String inventoryId);
    ResponseEntity<Object> getAllBloodData(String inventoryId);
    ResponseEntity<Object> getBedData(String inventoryId);
    ResponseEntity<Object> getNurseData(String inventoryId);
    ResponseEntity<Object> getFirstAids(String inventoryId);
    ResponseEntity<Object> getAnimalsFood(String inventoryId);
    ResponseEntity<Object> getDoctorsData(String inventoryId);
    ResponseEntity<Object> addNewInventory(Inventory inventory);
}
