package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import java.util.Date;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @Column(name="UserId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userid;


    private String password;


    private String name;


       private String email;



    private String gender;


    private String district;


    private String city;


    private String state;


    private String country;



    private String moblieno;



    private Boolean availableforvolunteer;



    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private List<Centralrepositoryofincident> centralrepositoryofincidents;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private List<Temporarydatabaseofincident> temporarydatabaseofincidents;


}



