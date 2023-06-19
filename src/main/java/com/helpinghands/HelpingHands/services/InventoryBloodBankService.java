package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.InventoryBloodBank;
import org.springframework.http.ResponseEntity;

public interface InventoryBloodBankService {
    ResponseEntity<Object> updateBloodBank(String inventoryId, InventoryBloodBank inventoryBloodBank);
}
