package com.example.demo.dao;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.CustomerDTO;

@Repository
public interface CustomerDAO extends CassandraRepository<CustomerDTO, Long> {
	// CrudRepository<CustomerDTO, Long>{

	public List<CustomerDTO> findByFullNameLike(String fullName);

}
