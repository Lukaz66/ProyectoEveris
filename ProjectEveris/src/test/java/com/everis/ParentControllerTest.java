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

import com.everis.models.Parent;
import com.everis.repositories.IParentRepo;
import com.everis.services.impl.ParentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentControllerTest {

	@MockBean
	IParentRepo parentRepo;

	@Autowired
	ParentServiceImpl parentService;

	@Test
	public void Get() {
		when(parentRepo.findAll()).thenReturn(new LinkedList<>());
		assertTrue(parentService.findAll().isEmpty());
		verify(parentRepo, times(1)).findAll();
	}

	@Test
	public void Post() {
		Parent parent = new Parent();
		parent.setGender("F");
		parent.setFirstName("Rias");
		parent.setMiddleName("Gremori");
		parent.setLastName("School");
		parent.setOtherParentDetail("Bailarina");

		parentService.save(parent);

		verify(parentRepo, times(1)).save(parent);
	}

}
