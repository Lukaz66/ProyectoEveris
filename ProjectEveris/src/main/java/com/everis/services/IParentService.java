package com.everis.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.models.Parent;

@Service
public interface IParentService {
	
	List<Parent> findAll();
	
	Parent save(Parent parent);
	
	Parent update(Parent parent);
	
	void delete(Long id);
	
}
