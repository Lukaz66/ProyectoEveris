package com.everis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.models.Parent;

@Repository
public interface IParentRepo extends JpaRepository<Parent, Long> {

}
