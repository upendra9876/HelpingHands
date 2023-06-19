package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.Constants;
import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.entities.InventoryVehicle;
import com.helpinghands.HelpingHands.repository.InventoryRepository;
import com.helpinghands.HelpingHands.repository.InventoryVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventoryVehicles,HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> getVehicleByInventoryId(String inventoryId){
        Optional<Inventory> vehicles = this.inventoryRepository.findById(inventoryId);
        if(vehicles.isPresent()){
            return new ResponseEntity<>(vehicles.get().getVehicle(),HttpStatus.OK);
        }
        return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> updateBloodBankByInventoryId(String inventoryId){

    }

}
