package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.Constants;
import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.entities.InventoryVehicle;
import com.helpinghands.HelpingHands.repository.InventoryBloodBankRepository;
import com.helpinghands.HelpingHands.repository.InventoryRepository;
import com.helpinghands.HelpingHands.repository.InventoryVehicleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class InventoryServiceImplementation implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryVehicleRepository inventoryVehicleRepository;

    @Autowired
    private InventoryBloodBankRepository inventoryBloodBankRepository;

    @Override
    public ResponseEntity getAllInventory(){
        List<Inventory> allInventory = this.inventoryRepository.findAll();
        if(allInventory.isEmpty()){
            return new ResponseEntity<>("No Inventory Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allInventory,HttpStatus.OK);
    }

    @Override
    public ResponseEntity getInventoryById(String id){
        Optional<Inventory> inventory = this.inventoryRepository.findById(id);
        if(inventory.isEmpty()){
            return new ResponseEntity<>("No Content Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory.get(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> getVehicleByType(String vehicleType, String inventoryId){
        Optional<Inventory> inventory= this.inventoryRepository.findById(inventoryId);
        if(inventory.isEmpty()){
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
        InventoryVehicle data = this.inventoryVehicleRepository.getVehicleDataByType(inventory.get().getVehicle().getId());
        if(vehicleType.equals("land")){
            return new ResponseEntity<>(vehicleType+":"+data.getLand(),HttpStatus.OK);
        }else if (vehicleType.equals("air")){
            return new ResponseEntity<>(vehicleType+":"+data.getAir(),HttpStatus.OK);
        } else if (vehicleType.equals("water")) {
            return new ResponseEntity<>(vehicleType+":"+data.getWater(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> getAmbulanceData(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isEmpty()){
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory.get().getAmbulance(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getWaterGallon(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isPresent()){
            return new ResponseEntity<>(inventory.get().getWaterGallon(),HttpStatus.OK);
        }
        return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getFoodPacket(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isPresent()){
            return new ResponseEntity<>(inventory.get().getFoodPacket(),HttpStatus.OK);
        }
        return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getAllBloodData(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isEmpty()){
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory.get().getBloodBank(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getBedData(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isEmpty()){
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory.get().getBeds(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAnimalsFood(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isEmpty()){
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory.get().getAnimalsFood(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getFirstAids(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isEmpty()){
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory.get().getFirstAids(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getDoctorsData(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isPresent()) {
            return new ResponseEntity<>(inventory.get().getDoctor(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getNurseData(String inventoryId){
        Optional<Inventory> inventory = this.inventoryRepository.findById(inventoryId);
        if(inventory.isEmpty()){
            return new ResponseEntity<>(Constants.DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventory.get().getNurse(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity addNewInventory(Inventory newInventory){
        try{
            this.inventoryVehicleRepository.save(newInventory.getVehicle());
            this.inventoryBloodBankRepository.save(newInventory.getBloodBank());
            this.inventoryRepository.save(newInventory);
            return new ResponseEntity<>("New Inventory Added",HttpStatus.OK);
        }catch (Exception e){
            log.error(e);
            return new ResponseEntity<>("Some Error Occurred",HttpStatus.SERVICE_UNAVAILABLE);
        }
    }



}
