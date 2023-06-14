package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Hospital {
    @Id
    private String id;
    private String hospitalName;
    private boolean hospitalAvailability;
    private long doctorAvailability;
    private long nurseAvailability;
    private long bedsAvailability;
    private long medikitAvailability;
    private long ambulanceAvailability;

}
