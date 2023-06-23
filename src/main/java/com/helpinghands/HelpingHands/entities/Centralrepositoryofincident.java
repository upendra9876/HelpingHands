package com.helpinghands.HelpingHands.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Centralrepositoryofincident {
    @Id
    private String id;
    @NotBlank(message = "Name must not be blank")
    private String name;


    @NotBlank(message = "District must not be blank")
    private String district;

    @NotBlank(message = "State must not be blank")
    private String State;

    @NotBlank(message = "Description must not be blank")
    private String Description;
    
    @Min(0)
    @Max(10000)
    private long Casualty;


    @Column(name = "End_date", columnDefinition = "DATE")
    private LocalDate incidentEndDate;


    @Column(name = "Date", columnDefinition = "DATE")
    private LocalDate incidentDate;

//    @Column(name = "time", columnDefinition = "TIME")
//    private LocalTime incidenttime;
}

