package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "inventory_blood_bank")
@NoArgsConstructor
@AllArgsConstructor
public class InventoryBloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ibb_id")
    private String id;

    @Column(name = "a+")
    private long APositive;

    @Column(name = "a-")
    private long ANegative;

    @Column(name = "ab+")
    private long ABPositive;

    @Column(name = "ab-")
    private long ABNegative;

    @Column(name = "b+")
    private long BPositive;

    @Column(name = "b-")
    private long BNegative;

    @Column(name = "o+")
    private long OPositive;

    @Column(name = "o-")
    private long ONegative;
}
