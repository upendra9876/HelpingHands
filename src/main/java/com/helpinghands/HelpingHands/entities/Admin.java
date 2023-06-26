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
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
    @Column(name="Moblie_no.")
    private Long moblieno;


}
