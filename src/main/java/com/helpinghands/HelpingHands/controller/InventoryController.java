package com.helpinghands.HelpingHands.controller;

import com.helpinghands.HelpingHands.entities.Inventory;
import com.helpinghands.HelpingHands.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory")
    public ResponseEntity getAllInventory(){
        return this.inventoryService.getAllInventory();
    }
    @GetMapping("/inventory/{inventoryId}")
    public ResponseEntity getInventoryById(@PathVariable("inventoryId") String id){
        return this.inventoryService.getInventoryById(id);
    }

    @PostMapping("/inventory")
    public ResponseEntity addInventory(@RequestBody Inventory newInventory){
        return this.inventoryService.addNewInventory(newInventory);
    }
}
