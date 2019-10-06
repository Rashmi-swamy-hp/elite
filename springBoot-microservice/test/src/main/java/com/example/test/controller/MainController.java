package com.example.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dao.PersonDAO;
import com.example.test.entity.Person;
import com.example.test.init.DataInit;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MainController {
	
	    @Autowired
	    private PersonDAO personDAO;
	    
	    @Autowired
	    private DataInit dataInit;
	 
	    @ResponseBody
	    @RequestMapping("/")
	    public ResponseEntity index() throws Exception{
	    	
	    	
	    	dataInit.run(null);
	    	
	        Iterable<Person> all = personDAO.findAll();
	 
	        StringBuilder sb = new StringBuilder();
	 
	        all.forEach(p -> sb.append(p.getFullName() + "<br>"));
	 
	        return ResponseEntity.ok(personDAO.findAll());
	        //return "Hi";
	    }
	    
	    @RequestMapping("/{fullName}")
	    public List<Person> getUser(@PathVariable String fullName) throws Exception{
	    	System.out.println("fullName: "+fullName);
	    	List<Person> person= personDAO.findByFullNameLike(fullName);
	    	
	        return personDAO.findByFullNameLike(fullName);
	        //return "Hi";
	    }
	    
	    @RequestMapping("/saveUser")
	    public Person saveUser(@RequestBody() Person person) throws Exception{
//	    	System.out.println("fullName: "+fullName);
//	    	List<Person> person= personDAO.findByFullNameLike(fullName);
	    	System.out.println("Person: "+person);
	    	personDAO.save(person);
	        return personDAO.save(person);
	        //personDAO.findByFullNameLike(fullName);
	        //return "Hi";
	    }
	    
	    @RequestMapping("/deleteUser/{id}")
	    public Person deleteUser(@PathVariable Long id) throws Exception{
//	    	System.out.println("fullName: "+fullName);
//	    	List<Person> person= personDAO.findByFullNameLike(fullName);
//	    	System.out.println("Person: "+person);
	    	personDAO.deleteById(id);
	        return null;
	        //personDAO.findByFullNameLike(fullName);
	        //return "Hi";
	    }
	    
	    @RequestMapping("/updateUser")
	    public Person updateUser(@RequestBody() Person person) throws Exception{

	    	Optional<Person> personFromDB = personDAO.findById(person.getId());
	    	
	    	personFromDB.get().setFullName(person.getFullName());
	        personDAO.save(personFromDB.get());
	        return personFromDB.get();
	        
	    }
	    
	    

}
