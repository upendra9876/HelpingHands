package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.entities.BloodBank;
import com.helpinghands.HelpingHands.entities.InventoryBloodBank;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

public interface InventoryBloodBankService {
    public InventoryBloodBank updateBloodBank(String incidentId, InventoryBloodBank bloodBank) throws NoSuchElementException;

    public InventoryBloodBank bloodUsedInIncident(String incidentId) throws NoSuchElementException;
}
