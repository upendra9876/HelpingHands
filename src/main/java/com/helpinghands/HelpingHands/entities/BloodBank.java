package com.helpinghands.HelpingHands.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BloodBank {
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String name;

	private String  available_qty;

	private String postal;

	private String District;

	private String State;

}
