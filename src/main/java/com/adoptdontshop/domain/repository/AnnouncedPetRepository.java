package com.adoptdontshop.domain.repository;

import com.adoptdontshop.domain.model.AnnouncedPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncedPetRepository extends JpaRepository<AnnouncedPet, Long>, AnnouncedPetRepositoryCustom{

}
