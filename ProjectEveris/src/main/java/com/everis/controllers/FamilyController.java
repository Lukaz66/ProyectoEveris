package com.everis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.models.Family;
import com.everis.services.IFamilyService;

@RestController
@RequestMapping("/api/V1.0/families")
public class FamilyController {

	@Autowired
	private IFamilyService family;
	
	@GetMapping
	public List<Family> get(){
		return family.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody Family fam) {
		family.save(fam);
	}
	
	@PutMapping
	public void update(@RequestBody Family fam) {
		family.save(fam);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		family.delete(id);
	}
}