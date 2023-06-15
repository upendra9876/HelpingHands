package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Column(name="adminId")
    @GeneratedValue(strategy = GenerationType.UUID)
    public String adminid;

    @NotBlank
    @Column(name="name")
    public String name;

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

    @NotBlank
    @Column(name="Pincode")
    private String pincode;

    @NotNull
    @Column(name="Moblie_no.")
    private Long moblieno;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "adminId")
    private List<Centralrepositoryofincident> centralrepositoryofincidents;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "adminId")
    private List<Temporarydatabaseofincident> temporarydatabaseofincidents;

}
