package com.helpinghands.HelpingHands.services;

import com.helpinghands.HelpingHands.Constants;
import com.helpinghands.HelpingHands.entities.BloodBank;
import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.entities.InventoryBloodBank;
import com.helpinghands.HelpingHands.entities.Temporarydatabaseofincident;
import com.helpinghands.HelpingHands.repository.InventoryBloodBankRepository;
import com.helpinghands.HelpingHands.repository.InventoryRepository;
import com.helpinghands.HelpingHands.repository.Temporarydatabaseofincidentdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class InventoryBloodBankServiceImplement implements InventoryBloodBankService{
    @Autowired
    private InventoryBloodBankRepository inventoryBloodBankRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private Temporarydatabaseofincidentdao temporarydatabaseofincidentdao;



    @Override
    public InventoryBloodBank updateBloodBank(String incidentId, InventoryBloodBank bloodBank) {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null) {
            Inventory inventory = incident.getInventory();
            InventoryBloodBank bloodBank1= inventory.getBloodBank();
            bloodBank1.setABNegative(bloodBank.getABNegative()+bloodBank1.getABNegative());
            bloodBank1.setANegative(bloodBank.getANegative()+bloodBank1.getANegative());
            bloodBank1.setABPositive(bloodBank.getABPositive()+bloodBank1.getABPositive());
            bloodBank1.setAPositive(bloodBank.getAPositive()+bloodBank1.getAPositive());
            bloodBank1.setBPositive(bloodBank.getBPositive()+bloodBank1.getBPositive());
            bloodBank1.setBNegative(bloodBank.getBNegative()+bloodBank1.getBNegative());
            bloodBank1.setONegative(bloodBank.getONegative()+bloodBank1.getONegative());
            bloodBank1.setOPositive(bloodBank.getOPositive()+bloodBank1.getOPositive());
            inventoryBloodBankRepository.save(bloodBank1);
            return bloodBank1;
        }
        else throw new NoSuchElementException("no incident found");
    }

    @Override
    public InventoryBloodBank bloodUsedInIncident(String incidentId) throws NoSuchElementException {
        Temporarydatabaseofincident incident= temporarydatabaseofincidentdao.findById(incidentId).get();
        if(incident!=null){
            return incident.getInventory().getBloodBank();
        }
        else throw new NoSuchElementException("no incident found");
    }

}
