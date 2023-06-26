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

   // @Size(min = 8,message = "please set password according to guidelines")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
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
