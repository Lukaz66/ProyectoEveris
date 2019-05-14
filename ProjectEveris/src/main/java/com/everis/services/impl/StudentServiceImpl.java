package com.everis.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.models.Student;
import com.everis.repositories.IStudentRepo;
import com.everis.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo studentRepo;
	
	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student update(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}

}
