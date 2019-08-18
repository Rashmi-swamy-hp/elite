package com.example.demo.init;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.CustomerDTO;


@Component
public class DataInit implements ApplicationRunner {
	@Autowired
	private CustomerDAO customerDAO;

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public DataInit(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		long count = 0;// customerDTO.count();

		if (count == 0) {
			CustomerDTO p1 = new CustomerDTO();

			p1.setFullName("John");

			Date d1 = df.parse("1980-12-20");
			p1.setCreationDate(new Date());
			p1.setUpdatedDate(new Date());
			p1.setDateOfBirth(d1);
			//
			CustomerDTO p2 = new CustomerDTO();

			p2.setFullName("Smith");
			Date d2 = df.parse("1985-11-11");
			p2.setCreationDate(new Date());
			p2.setUpdatedDate(new Date());
			p2.setDateOfBirth(d2);

			customerDAO.save(p1);
			customerDAO.save(p2);
		}

	}

}
