package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.Inventory;
import org.springframework.http.ResponseEntity;

public interface InventoryService {

    ResponseEntity getAllInventory();
    ResponseEntity getInventoryById(String id);
    ResponseEntity addNewInventory(Inventory inventory);
}
