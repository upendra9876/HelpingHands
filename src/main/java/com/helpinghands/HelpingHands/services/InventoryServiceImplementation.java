package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImplementation implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public ResponseEntity getAllInventory(){
        List<Inventory> allInventory = this.inventoryRepository.findAll();
        if(allInventory.isEmpty()){
            return new ResponseEntity("No Inventory Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(allInventory,HttpStatus.OK);
    }

    @Override
    public ResponseEntity getInventoryById(String id){
        Inventory inventory = this.inventoryRepository.findById(id).get();
        if(inventory == null){
            return new ResponseEntity<>("No Content Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addNewInventory(Inventory newInventory){
        try{
            this.inventoryRepository.save(newInventory);
            return new ResponseEntity("New Inventory Added",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Some Error Occurred",HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
