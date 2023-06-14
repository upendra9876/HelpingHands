package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "inventory_blood_bank")
public class InventoryBloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ibb_id")
    private String id;
    @Column(name = "A+")
    private long aPositive;
    @Column(name = "A-")
    private long aNegative;
    @Column(name = "AB+")
    private long abPositive;
    @Column(name = "AB-")
    private long abNegative;
    @Column(name = "B+")
    private long bPositive;
    @Column(name = "B-")
    private long bNegative;
    @Column(name = "O+")
    private long oPositive;
    @Column(name = "O-")
    private long oNegative;
}
