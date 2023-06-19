package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.Constants;
import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.entities.InventoryBloodBank;
import com.helpinghands.HelpingHands.repository.InventoryBloodBankRepository;
import com.helpinghands.HelpingHands.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class InventoryBloodBankServiceImplement implements InventoryBloodBankService{
    @Autowired
    private InventoryBloodBankRepository inventoryBloodBankRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    public ResponseEntity<Object> updateBloodBank(String inventoryId, InventoryBloodBank inventoryBloodBank){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isPresent() && (inventory.get().getBloodBank().getId() != null)){
            //inventory.get().getBloodBank();
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }

        return new ResponseEntity<>(Constants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
