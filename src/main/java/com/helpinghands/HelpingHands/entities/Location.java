package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    private String postalcode;

    private String district;

    private long manmadedisaster;
    private long naturaldisaster;
    private long totaldisaster;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postal")
    private List<Centralrepositoryofincident> centralrepositoryofincidentList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postal")
    private List<Temporarydatabaseofincident> temporarydatabaseofincidents;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postal")
    private List<Users> users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postal")
    private Admin admin;


}
