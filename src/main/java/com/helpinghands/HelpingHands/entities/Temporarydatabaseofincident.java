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


//
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory")
    private Inventory inventory;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = BloodBank.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "org_Id")
    private List<BloodBank> bloodbanks;;


    @OneToMany(cascade = CascadeType.ALL,targetEntity= Relief.class,fetch = FetchType.EAGER)
    @JoinColumn(name="Org_Id")
    private List<Relief> Relief_personal;

    @OneToMany(cascade = CascadeType.ALL,targetEntity=Hospital.class,fetch = FetchType.EAGER)
    @JoinColumn(name="Type")
    private List<Hospital> hospital;





}



