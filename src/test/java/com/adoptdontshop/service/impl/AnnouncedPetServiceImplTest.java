package com.adoptdontshop.service.impl;

import com.adoptdontshop.domain.model.AnnouncedPet;
import com.adoptdontshop.domain.model.Province;
import com.adoptdontshop.domain.model.User;
import com.adoptdontshop.domain.repository.AnnouncedPetRepository;
import com.adoptdontshop.enumaration.PetType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AnnouncedPetServiceImplTest {

    @Mock
    AnnouncedPetRepository repository;

    @InjectMocks
    AnnouncedPetServiceImpl announcedPetService;

//    @BeforeEach
//    void setUp() {
//    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByType() {
        List<AnnouncedPet> pets = new ArrayList<>();
        AnnouncedPet pet = new AnnouncedPet(1, PetType.CAT, null, new Province(1, "Ankara"), "xyz", "", new User(1, "abc@efg.com", "Niho"));
        pets.add(pet);
        given(repository.findByPetType(PetType.CAT)).willReturn(pets);

        List<AnnouncedPet> foundPets = announcedPetService.getByType(PetType.CAT, 1);
        assertNotNull(foundPets);
        verify(repository).findByPetType(any(PetType.class));
    }

    @Test
    void getByProvince() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}