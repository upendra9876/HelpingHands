package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class NDRFngo {
    @Id
    private String ID;
    private String organsationName;
    private long personAvailability;
    private long vehicleAvailability;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Vehicles.class)
    @JoinColumn(name = "organisationId")
    private List<Vehicles> vehicles;
}
