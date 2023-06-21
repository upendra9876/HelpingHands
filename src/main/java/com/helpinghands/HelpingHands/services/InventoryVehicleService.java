package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.InventoryVehicle;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

public interface InventoryVehicleService {

    public InventoryVehicle updateVehicleCountForIncident(String incidentId, InventoryVehicle vehicle) throws NoSuchElementException;

    public InventoryVehicle getAllVehicleUsedInIncident(String incidentId) throws  NoSuchElementException;
}
