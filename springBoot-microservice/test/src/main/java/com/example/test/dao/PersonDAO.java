package com.example.test.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.test.entity.Person;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {
	
	public List<Person> findByFullNameLike(String fullName);
	
}
