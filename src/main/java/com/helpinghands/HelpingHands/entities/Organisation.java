package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Organisation {
    @Id
    private String orgId;
    private String organisationType;
    private String incidentId ;
    private long organisationNo;
    private String inventoryId;
    private String hospitalId;
    private String bloodBankId;
    private String ndrfNgoId;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Hospital.class)
    @JoinColumn(name = "hospitalId")
    private List<Hospital> hospitals;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = BloodBank.class)
    @JoinColumn(name = "bloodBankId")
    private List<BloodBank> bloodbanks;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = NDRFngo.class)
    @JoinColumn(name = "ndrfNgoId")
    private List<NDRFngo> ndrFngos ;


    @OneToMany(cascade = CascadeType.ALL,targetEntity=NDRFngo.class)
    @JoinColumn(name="Type")
    private List<NDRFngo> ndrf_ngo;

    @OneToMany(cascade = CascadeType.ALL,targetEntity=Hospital.class)
    @JoinColumn(name="Type")
    private List<Hospital> hospital;
}
