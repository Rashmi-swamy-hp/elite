package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.CustomerDTO;
import com.example.demo.init.DataInit;

@RestController
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private DataInit dataInit;

	/**
	 * Fetches all customers.
	 */
	@ResponseBody
	@RequestMapping("/")
	public ResponseEntity index() throws Exception {

		dataInit.run(null);

		Iterable<CustomerDTO> all = customerDAO.findAll();

		StringBuilder sb = new StringBuilder();

		all.forEach(p -> sb.append(p.getFullName() + "<br>"));

		return ResponseEntity.ok(customerDAO.findAll());

	}

	/**
	 * Fetches all customer based on customer name.
	 */
	@RequestMapping("/{fullName}")
	public List<CustomerDTO> getUser(@PathVariable String fullName) throws Exception {
		// System.out.println("fullName: "+fullName);
		List<CustomerDTO> customer = customerDAO.findByFullNameLike(fullName);
		return customer;

	}

	/**
	 * to save customer.
	 */
	@RequestMapping("/saveCustomer")
	public CustomerDTO saveCustomer(@RequestBody() CustomerDTO customer) throws Exception {

		// System.out.println("customer: "+customer);
		customer.setCreationDate(new Date());
		customer.setUpdatedDate(new Date());
		customerDAO.save(customer);
		return customerDAO.save(customer);
	}

	/**
	 * deletes customer based on customer id.
	 */
	@RequestMapping("/deleteCustomer/{id}")
	public CustomerDTO deleteUser(@PathVariable Long id) throws Exception {

		customerDAO.deleteById(id);
		return null;

	}

	/**
	 * updates customer info.
	 */
	@RequestMapping("/updateCustomer")
	public CustomerDTO updateCustomer(@RequestBody() CustomerDTO customer) throws Exception {

		Optional<CustomerDTO> customerFromDB = customerDAO.findById(customer.getId());

		customerFromDB.get().setFullName(customer.getFullName());
		customerFromDB.get().setUpdatedDate(new Date());

		customerDAO.save(customerFromDB.get());
		return customerFromDB.get();

	}

}
