package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Vehicles {
    @Id
    private String id;
    private long landVehicle;
    private long waterVehicle;
    private long airVehicle;
}
