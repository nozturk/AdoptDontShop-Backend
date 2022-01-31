package com.adoptdontshop.domain.model;

import com.adoptdontshop.enumaration.PetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncedPet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private PetType petType;
	
	private byte[] photo;
	
	@ManyToOne()
    @JoinColumn(name="province_id")
	@NotNull
	private Province province;

	@NotNull
	private String address; 

	private String additionalInfo;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	@NotNull
	private User user;
}
