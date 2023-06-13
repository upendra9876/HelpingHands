package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    private String userid;

    private String name;

    private String postalcode;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Centralrepositoryofincident> centralrepositoryofincidents;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Temporarydatabaseofincident> temporarydatabaseofincidents;


}



