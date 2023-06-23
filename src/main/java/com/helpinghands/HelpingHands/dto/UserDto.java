package com.helpinghands.HelpingHands.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank
    @Column(name="name")
    private String name;

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
    @Column(name="Moblie_no.")
    private Long moblieno;

    @NotBlank
    @Column(name="Available_for_Volunteer")
    private Boolean availableforvolunteer;
}
