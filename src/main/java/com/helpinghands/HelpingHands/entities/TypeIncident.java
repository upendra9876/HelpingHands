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
public class TypeIncident {
    @Id
    private String typeid;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeid")
    private List<Centralrepositoryofincident> centralrepositoryofincidents;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeid")
    private List<Temporarydatabaseofincident> temporarydatabaseofincidents ;


}
