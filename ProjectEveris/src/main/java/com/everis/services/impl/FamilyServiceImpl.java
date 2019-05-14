package com.everis.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.models.Family;
import com.everis.repositories.IFamilyRepo;
import com.everis.services.IFamilyService;

@Service
public class FamilyServiceImpl implements IFamilyService {

	@Autowired
	private IFamilyRepo familyRepo;
	
	@Override
	public List<Family> findAll() {
		return familyRepo.findAll();
	}

	@Override
	public Family save(Family family) {
		return familyRepo.save(family);
	}

	@Override
	public Family update(Family family) {
		return familyRepo.save(family);
	}

	@Override
	public void delete(Long id) {
		familyRepo.deleteById(id);
	}

}
