package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventory_vehicle")
@Data
public class InventoryVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "iv_id")
    private String id;
    @Column(name = "land")
    private long land;
    @Column(name = "air")
    private long air;
    @Column(name = "water")
    private long water;
}
