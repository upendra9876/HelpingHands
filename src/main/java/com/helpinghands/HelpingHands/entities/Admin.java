package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Column(name="adminId")
    @GeneratedValue(strategy = GenerationType.UUID)
    public String adminid;

    @NotBlank
    @Column(name="name")
    public String name;

    @Email
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
    @Pattern(regexp = "(^$[0-9]{10})")
    @Column(name="Moblie_no.")
    private Long moblieno;

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
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
}
