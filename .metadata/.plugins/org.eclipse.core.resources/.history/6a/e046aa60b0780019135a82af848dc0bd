package com.everis;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.everis.repositories.IStudentRepo;
import com.everis.services.impl.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

	@MockBean
	IStudentRepo studentRepo;
	
	@Autowired
	StudentServiceImpl studentService;
	
	@Test
	public void Get() {
		when(studentRepo.findAll()).thenReturn(new LinkedList<>());
		assertTrue(studentService.findAll().isEmpty());
		verify(studentRepo, times(1)).findAll();		
	}
}
