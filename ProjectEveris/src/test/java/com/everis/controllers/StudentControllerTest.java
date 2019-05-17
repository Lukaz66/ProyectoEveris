package com.everis.controllers;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockRequestDispatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.everis.models.Student;
import com.everis.services.IStudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

  @Autowired
  private MockMvc mokMvc;

  @MockBean
  IStudentService studentService;

  @Test
  public void testGet() throws Exception {
    List<Student> list = new ArrayList<>();
    given(studentService.findAll()).willReturn(list);
    this.mokMvc.perform(MockMvcRequestBuilders.get("/api/V1.0/students").accept(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$./api/V1.0/students").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.students[*].studentId").isNotEmpty());

//    List<Student> list = new ArrayList<>();
//    given(studentService.findAll()).willReturn(list);
//    this.mokMvc.perform(get("/api/V1.0/students"))
//      .andExpect(status().isOk())
//      .andExpect( content().json("[]"));
  }

  @Test
  public void testSave() throws Exception {
    studentService.save(new Student());
    this.mokMvc
        .perform(
            post("/api/V1.0/students").contentType(MediaType.APPLICATION_JSON).content(asJsonString(new Student())))
        .andExpect(status().isCreated());
  }

  @Test
  public void testUpdate() throws Exception {
    this.mokMvc
        .perform(MockMvcRequestBuilders.put("/api/V1.0/students").content(asJsonString(new Student()))
            .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.idStudent").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("M"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Lukas"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.middleName").value("Zeus"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Llanos"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.otherStudentDetail").value("desarrollador"));
  }

  @Test
  public void testDelete() throws Exception {
    this.mokMvc.perform(MockMvcRequestBuilders.delete("/api/V1.0/students/1", 1)).andExpect(status().isAccepted());

  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}