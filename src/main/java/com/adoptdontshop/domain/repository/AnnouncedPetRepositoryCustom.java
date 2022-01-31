package com.adoptdontshop.domain.repository;

import com.adoptdontshop.domain.model.AnnouncedPet;
import com.adoptdontshop.enumaration.PetType;

import java.util.List;

public interface AnnouncedPetRepositoryCustom {
    List<AnnouncedPet> findByType(PetType petType, int page);
}
