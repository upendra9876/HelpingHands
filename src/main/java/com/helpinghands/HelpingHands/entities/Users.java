package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Column(name="UserId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userid;

    @NotBlank
    @Column(name="name")
    private String name;

    @NotBlank
    @Column(name="Email")
    private String email;

    @NotBlank
    @Column(name="gender")
    private String gender;

    @NotBlank
    @Column(name="district")
    private String district;

    @NotBlank
    @Column(name="City")
    private String city;

    @NotBlank
    @Column(name="State")
    private String state;

    @NotBlank
    @Column(name="Country")
    private String country;

    @NotNull
    @Column(name="Moblie_no.")
    private Long moblieno;

    @NotBlank
    @Column(name="Available_for_Volunteer")
    private Boolean availableforvolunteer;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Centralrepositoryofincident> centralrepositoryofincidents;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Temporarydatabaseofincident> temporarydatabaseofincidents;


}



