package com.everis.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.models.Parent;
import com.everis.repositories.IParentRepo;
import com.everis.services.IParentService;

@Service
public class ParentServiceImpl implements IParentService {

	@Autowired
	private IParentRepo parentRepo;
	
	@Override
	public List<Parent> findAll() {
		return parentRepo.findAll();
	}

	@Override
	public Parent save(Parent parent) {
		return parentRepo.save(parent);
	}

	@Override
	public Parent update(Parent parent) {
		return parentRepo.save(parent);
	}

	@Override
	public void delete(Long id) {
		parentRepo.deleteById(id);
	}

}