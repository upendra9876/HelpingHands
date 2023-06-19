package com.helpinghands.HelpingHands.services;

import org.springframework.http.ResponseEntity;

public interface InventoryVehicleService {
    ResponseEntity<Object> getAllVehicle();

    ResponseEntity<Object> getVehicleByInventoryId(String inventoryId);
    ResponseEntity<Object> updateBloodBankByInventoryId(String inventoryId);
}
