package com.everis.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.models.Student;

@Service
public interface IStudentService {

	List<Student> findAll();
	
	Student save(Student student);
	
	Student update(Student student);
	
	void delete(Long id);
	
}
