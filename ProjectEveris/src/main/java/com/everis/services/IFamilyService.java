package com.everis.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.models.Family;

@Service
public interface IFamilyService {
	
	List<Family> findAll();
	
	Family save(Family family);
	
	Family update(Family family);
	
	void delete(Long id);
	
}
