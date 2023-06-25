package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@Entity
public class Relief {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String Name;

	private String Vehicle;

	private String Personnel;

	private String Equipments;

	private String state;

    
}
