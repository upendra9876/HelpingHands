package com.helpinghands.HelpingHands.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Temporarydatabaseofincident {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;
    //@NotBlank(message = "Name must not be empty")
    public String name;
    //@NotBlank(message = "postal must not be empty")
    //@NotNull(message = "refsd")
    public String postalcode;
    //@NotBlank(message = "must not be empty")
    private String District;
    //@NotBlank(message = "must not be empty")
    private String Description;
    private long Casualty;
   //@NotBlank(message = "wrd")
    private boolean Status;

    @Temporal(TemporalType.DATE)
    private Date incidenteffectdate;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "HH:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm",locale = "")
    private Date incidenttime;
    @Temporal(TemporalType.DATE)
    private Date IncidentDate;
}



