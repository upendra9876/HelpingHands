package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orgId;
    private String name;



}
