package com.helpinghands.HelpingHands.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReportIncident {


    public String id;

    @NotBlank(message = "name must not be blank")
    public String name;


    @NotBlank(message = "District must not be blank")
    private String District;

    @NotBlank(message = "State must not be blank")
    private String State;

    @NotBlank(message = "Description must not be blank")
    private String Description;
    private long Casualty;






    @Column(name = "Date", columnDefinition = "DATE")
    private LocalDate incidentDate;
}
