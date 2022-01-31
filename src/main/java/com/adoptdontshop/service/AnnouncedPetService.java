package com.adoptdontshop.service;

import com.adoptdontshop.domain.model.AnnouncedPet;
import com.adoptdontshop.enumaration.PetType;

import java.util.List;

public interface AnnouncedPetService {
	AnnouncedPet get(Long announcedPetId);
	List<AnnouncedPet> getAll();
	List<AnnouncedPet> getByType(PetType  petType, int page);
	List<AnnouncedPet> getByProvince(int provinceId);
	Long save(AnnouncedPet announcedPet);
	void update(AnnouncedPet announcedPet);
	void delete(int announcedPetId);

}
