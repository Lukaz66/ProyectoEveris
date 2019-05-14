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

import com.everis.models.Parent;
import com.everis.services.IParentService;

@RestController
@RequestMapping("/api/V1.0/parents")
public class ParentController {

	@Autowired
	private IParentService parentService;
	
	@GetMapping
	public List<Parent> get(){
		return parentService.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody Parent par) {
		parentService.save(par);
	}
	
	@PutMapping
	public void update(@RequestBody Parent par) {
		parentService.save(par);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {		
		parentService.delete(id);
	}
}
