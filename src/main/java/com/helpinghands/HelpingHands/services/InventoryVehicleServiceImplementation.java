package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.Constants;
import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.entities.InventoryVehicle;
import com.helpinghands.HelpingHands.entities.Temporarydatabaseofincident;
import com.helpinghands.HelpingHands.repository.InventoryRepository;
import com.helpinghands.HelpingHands.repository.InventoryVehicleRepository;
import com.helpinghands.HelpingHands.repository.Temporarydatabaseofincidentdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InventoryVehicleServiceImplementation implements InventoryVehicleService{
    @Autowired
    private InventoryVehicleRepository inventoryVehicleRepository;
    @Autowired
    private InventoryRepository inventoryRepository;



    @Autowired
    private Temporarydatabaseofincidentdao temporarydatabaseofincidentdao;


    @Override
    public InventoryVehicle updateVehicleCountForIncident(String incidentId, InventoryVehicle vehicle)throws NoSuchElementException {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            Inventory inventory= incident.getInventory();
            InventoryVehicle vehicle1= inventory.getVehicle();
            vehicle1.setAir(vehicle1.getAir()+vehicle.getAir());
            vehicle1.setLand(vehicle.getLand()+vehicle1.getLand());
            vehicle1.setWater(vehicle1.getWater()+vehicle.getWater());
            inventoryVehicleRepository.save(vehicle1);
            return vehicle1;

        }
        else throw new NoSuchElementException("no incident found");
    }

    @Override
    public InventoryVehicle getAllVehicleUsedInIncident(String incidentId) {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            return incident.getInventory().getVehicle();
        }
        else throw new NoSuchElementException("please provide valid incidentId");
    }
}
