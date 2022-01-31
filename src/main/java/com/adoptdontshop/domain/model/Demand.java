package com.adoptdontshop.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Entity
@Getter
public class Demand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "demander_user_id")
	private User demander;
	
	@ManyToOne
	@JoinColumn(name="announced_pet_id")
	private AnnouncedPet pet;
	
	private String comment;
}
