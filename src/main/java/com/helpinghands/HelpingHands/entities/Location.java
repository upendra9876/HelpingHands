package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;

import static org.hibernate.annotations.FetchMode.JOIN;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Location {
    @Id
    private String postalcode;

    @NotBlank(message = "District must not be blank")
    private String district;

    @Min(0)
    private long totaldisaster;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "postal")
    private List<Centralrepositoryofincident> centralrepositoryofincidentList;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "postal")
    private List<Temporarydatabaseofincident> temporarydatabaseofincidents;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "postal")
    private List<Users> users;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "admin")
    private Admin admin;


}
