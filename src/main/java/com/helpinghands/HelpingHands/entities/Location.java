package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    private String postalcode;

    @NotBlank(message = "District must not be blank")
    private String district;

    @Min(0)
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
    @JoinColumn(name = "admin")
    private Admin admin;


}
