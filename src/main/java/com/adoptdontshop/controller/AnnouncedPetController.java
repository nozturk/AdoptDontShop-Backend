package com.adoptdontshop.controller;

import com.adoptdontshop.domain.model.AnnouncedPet;
import com.adoptdontshop.enumaration.PetType;
import com.adoptdontshop.service.AnnouncedPetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/announcedPet")
@CrossOrigin(origins = "http://localhost:4200")
public class AnnouncedPetController {
	
	private final AnnouncedPetService announcedPetService;
	
	public AnnouncedPetController(AnnouncedPetService announcedPetService) {
		super();
		this.announcedPetService = announcedPetService;
	}

	@GetMapping("/type")
	public ResponseEntity<PetType[]> getPetTypes(){
		return ResponseEntity.ok(PetType.values());
	}
	
	@GetMapping("/type/{petType}")
	public ResponseEntity<List<AnnouncedPet>> getByType(@PathVariable PetType petType, @RequestParam int page){
		return ResponseEntity.ok(announcedPetService.getByType(petType, page));
	}
	
	@GetMapping()
	public ResponseEntity<List<AnnouncedPet>> getAll(){
		return ResponseEntity.ok(announcedPetService.getAll());
	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody AnnouncedPet announcedPet, UriComponentsBuilder b){
		Long id = announcedPetService.save(announcedPet);
		UriComponents uriComponents =
				b.path("/api/v1/announcedPet").buildAndExpand(id);
		return  ResponseEntity.created(uriComponents.toUri()).build();
	}


}
