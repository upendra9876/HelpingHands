package com.helpinghands.HelpingHands.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "name must not be null")
    @Column(name="name")
    private String name;

    @Email(message = "email must not be null or invalid email")
    @Column(name="Email")
    private String email;


   //@Pattern(regexp = "^[a-zA-Z]{8,}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;


    @Column(name="gender")
    private String gender;

    @NotBlank(message = "District must not be null")
    @Column(name="district")
    private String district;

    @NotBlank(message = "City must not be null")
    @Column(name="City")
    private String city;

    @NotBlank(message = "State must not be null")
    @Column(name="State")
    private String state;

    @NotBlank(message = "Country must not be null")
    @Column(name="Country")
    private String country;

    @NotBlank
    @Column(name="Moblie_no.")
   @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
    private String moblieno;

}
