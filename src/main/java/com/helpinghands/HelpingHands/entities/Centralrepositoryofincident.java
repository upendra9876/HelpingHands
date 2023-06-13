package com.helpinghands.HelpingHands.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Centralrepositoryofincident {
    @Id
    private String id;

    private String name;

    public String postalcode;

    private String district;

    private String State;

    private String Description;

    private long Casualty;

    @Temporal(TemporalType.DATE)
    private Date incidentEndDate;


    @Temporal(TemporalType.DATE)
    private Date incidentDate;
}

