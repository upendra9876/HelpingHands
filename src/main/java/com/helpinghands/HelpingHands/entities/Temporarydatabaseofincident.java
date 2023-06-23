package com.helpinghands.HelpingHands.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Temporarydatabaseofincident {
    @Id
    public String id;

    @NotBlank(message = "name must not be blank")
    public String name;


    @NotBlank(message = "District must not be blank")
    private String District;

    @NotBlank(message = "State must not be blank")
    private String State;

    @NotBlank(message = "Description must not be blank")
    private String Description;
    @Min(0)
    @Max(10000)
    private long Casualty;

    private boolean Status;

    @Column(name = "End_date", columnDefinition = "DATE")
    private LocalDate incidentEndDate;


    @Column(name = "Date", columnDefinition = "DATE")
    private LocalDate incidentDate;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
//    @Column(name = "time", columnDefinition = "TIME")
//    private LocalTime incidenttime;

//    @Temporal(TemporalType.DATE)
//    private Date incidenteffectdate;
//
//    @Temporal(TemporalType.TIME)
//    @DateTimeFormat(style = "HH:mm")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm",locale = "")
//    private Date incidenttime;
//
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
//    private Date IncidentDate;
//
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory")
    private Inventory inventory;



    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "incident_id")
    private List<Organisation> organisations;


}



