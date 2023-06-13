package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    public String id;
    public String name;
    public String postalcode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "adminId")
    private List<Centralrepositoryofincident> centralrepositoryofincidents;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "adminId")
    private List<Temporarydatabaseofincident> temporarydatabaseofincidents;
}
