package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.InventoryVehicle;
import com.helpinghands.HelpingHands.repository.InventoryRepository;
import com.helpinghands.HelpingHands.repository.InventoryVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryVehicleServiceImplementation implements InventoryVehicleService{
    @Autowired
    private InventoryVehicleRepository inventoryVehicleRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public ResponseEntity<Object> getAllVehicle(){
        List<InventoryVehicle> inventoryVehicles = this.inventoryVehicleRepository.findAll();
        if(inventoryVehicles.isEmpty()){
            return new ResponseEntity<>("No vehicle found in Inventory", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventoryVehicles,HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> getVehicleByInventoryId(String inventoryId){
        InventoryVehicle vehicles = this.inventoryRepository.findById(inventoryId).isPresent()?this.inventoryRepository.findById(inventoryId).get().getVehicle() : null;
        if(vehicles != null){
            return new ResponseEntity<>(vehicles,HttpStatus.OK);
        }
        return new ResponseEntity<>("No Vehicle Found",HttpStatus.NOT_FOUND);
    }

}
