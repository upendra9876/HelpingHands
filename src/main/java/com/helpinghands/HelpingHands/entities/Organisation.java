package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orgId;

    private String name;


    @OneToMany(cascade = CascadeType.ALL,targetEntity = BloodBank.class)
    @JoinColumn(name = "bloodBankId")
    private List<BloodBank> bloodbanks;
;


    @OneToMany(cascade = CascadeType.ALL,targetEntity=NDRFngo.class)
    @JoinColumn(name="Type")
    private List<NDRFngo> ndrf_ngo;

    @OneToMany(cascade = CascadeType.ALL,targetEntity=Hospital.class)
    @JoinColumn(name="Type")
    private List<Hospital> hospital;
}
