package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BloodBank {
    @Id
    private String Id;
    private String bloodBankName;
    private String bloodType;
    private long availableQuantity;
    private String city;

}
