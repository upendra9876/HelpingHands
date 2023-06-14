package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String inventoryId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_vehicle_id")
    private InventoryVehicle vehicleId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_blood_bank_id")
    private InventoryBloodBank bloodBankId;

    @Column(name = "water_gallon")
    private long waterGallon;

    @Column(name = "food_packet")
    private long foodPacket;

    @Column(name = "first_aids")
    private long firstAids;

    @Column(name = "animals_food")
    private long animalsFood;

    @Column(name = "doctor")
    private long doctor;

    @Column(name = "nurse")
    private long nurse;

    @Column(name = "ambulance")
    private long ambulance;

    @Column(name = "beds")
    private long beds;
}
