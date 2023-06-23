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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getMoblieno() {
        return moblieno;
    }

    public void setMoblieno(Long moblieno) {
        this.moblieno = moblieno;
    }

    public Boolean getAvailableforvolunteer() {
        return availableforvolunteer;
    }

    public void setAvailableforvolunteer(Boolean availableforvolunteer) {
        this.availableforvolunteer = availableforvolunteer;
    }

    public List<Centralrepositoryofincident> getCentralrepositoryofincidents() {
        return centralrepositoryofincidents;
    }

    public void setCentralrepositoryofincidents(List<Centralrepositoryofincident> centralrepositoryofincidents) {
        this.centralrepositoryofincidents = centralrepositoryofincidents;
    }

    public List<Temporarydatabaseofincident> getTemporarydatabaseofincidents() {
        return temporarydatabaseofincidents;
    }

    public void setTemporarydatabaseofincidents(List<Temporarydatabaseofincident> temporarydatabaseofincidents) {
        this.temporarydatabaseofincidents = temporarydatabaseofincidents;
    }
}



