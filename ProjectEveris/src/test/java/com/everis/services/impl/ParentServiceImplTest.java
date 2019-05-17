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

import com.everis.models.Parent;
import com.everis.repositories.IParentRepo;

@RunWith(MockitoJUnitRunner.class)
public class ParentServiceImplTest {

  @InjectMocks
  private ParentServiceImpl parentService;
  
  @Mock
  private IParentRepo parentRepo;
  
  @Test
  public void testFindAll() {
    List<Parent> list = new ArrayList<>();
    given(parentRepo.findAll()).willReturn(list);
    assertEquals(list, parentService.findAll());
  }

  @Test
  public void testSave() {
    given(parentRepo.save(new Parent())).willReturn(new Parent());
    assertEquals(new Parent(), parentService.save(new Parent()));
  }

  @Test
  public void testUpdate() {
    given(parentRepo.save(new Parent())).willReturn(new Parent());
    assertEquals(new Parent(), parentService.update(new Parent()));
  }

  @Test
  public void testDelete() {
   parentRepo.deleteById(1L);
   parentService.delete(1L);
  }

}
