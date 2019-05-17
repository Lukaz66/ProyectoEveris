package com.everis.services.impl;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.everis.models.Student;
import com.everis.repositories.IStudentRepo;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

  @InjectMocks
  private StudentServiceImpl studentService;
  
  @Mock
  private IStudentRepo studentRepo;
  
  @Test
  public void testFindAll() {
    List<Student> list = new ArrayList<>();
    given(studentRepo.findAll()).willReturn(list);
    assertEquals(list, studentService.findAll());
  }

  @Test
  public void testSave() {
    Student student = new Student();
    student.setStudentId(1L);
    student.setGender("M");
    student.setFirstName("Lukas");
    student.setMiddleName("Stiven");
    student.setLastName("Llanos");
    student.setOtherStudentDetail("Desarrollador");
    given(studentRepo.save(new Student())).willReturn(new Student());
    assertEquals(new Student(), studentService.save(new Student()));
  }

  @Test
  public void testUpdate() {
    given(studentRepo.save(new Student())).willReturn(new Student());
    assertEquals(new Student(), studentService.update(new Student()));
  }

  @Test
  public void testDelete() {
    studentRepo.deleteById(1L);
    studentService.delete(1l);
  }

}
