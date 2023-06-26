package com.helpinghands.HelpingHands.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Locationdto {
    @Id
    private String postalcode;


    @NotBlank(message = "District must not be blank")
    private String district;


}
