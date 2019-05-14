package com.everis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.models.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Long> {

}
