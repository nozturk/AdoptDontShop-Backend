package com.adoptdontshop.service.impl;

import com.adoptdontshop.domain.model.AnnouncedPet;
import com.adoptdontshop.domain.repository.AnnouncedPetRepository;
import com.adoptdontshop.enumaration.PetType;
import com.adoptdontshop.service.AnnouncedPetService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnnouncedPetServiceImpl implements AnnouncedPetService {
	
	private final AnnouncedPetRepository announcedPetRepository;

	public AnnouncedPetServiceImpl(AnnouncedPetRepository announcedPetRepository) {
		super();
		this.announcedPetRepository = announcedPetRepository;
	}

	@Override
	public AnnouncedPet get(Long announcedPetId) {
		return announcedPetRepository.getById(announcedPetId);
		
	}

	@Override
	public List<AnnouncedPet> getAll() {
		return announcedPetRepository.findAll();
	}

	@Override
	public List<AnnouncedPet> getByType(PetType petType, int page) {
		return announcedPetRepository.findByType(petType, page);
	}

	@Override
	public List<AnnouncedPet> getByProvince(int provinceId) {
		return null;
	}

	@Override
	public Long save(AnnouncedPet announcedPet) {
		AnnouncedPet announcedPet1 = announcedPetRepository.save(announcedPet);
		return announcedPet1.getId();
	}

	@Override
	public void update(AnnouncedPet announcedPet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int announcedPetId) {
		// TODO Auto-generated method stub
		
	}
	
    

}
