package com.details.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.details.dao.AddressDao;
import com.details.entity.Address;
import com.details.entity.EmployeeDetails;
import com.details.exceptions.DetailsNotFoundException;
import com.details.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class HomeController {

	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AddressDao addressDao;
	
	@GetMapping("/getAll") ResponseEntity<List<EmployeeDetails>> getAllCustomers() {
		List<EmployeeDetails> list = employeeService.findAll();
		LOGGER.info("List Of Customers:"+list);
		return new ResponseEntity<List<EmployeeDetails>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	

	
	@GetMapping("getById/{id}")
	public EmployeeDetails getById(@PathVariable int id) throws Exception{
		
		EmployeeDetails employeeDetails = employeeService.findByUserId(id);
		
		
		if (employeeDetails == null) {
			throw new DetailsNotFoundException("Details not founded " +id);
		} else {
			return employeeDetails;	
		}
	}
	
	@PostMapping("save")
	public ResponseEntity<EmployeeDetails> saveEmployeeDetails(@RequestBody EmployeeDetails details){
		
		details.setId(0);
		details = employeeService.save(details);
		LOGGER.info("List Of Customers:"+details);
		if (details == null) {
			return new ResponseEntity<EmployeeDetails>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<EmployeeDetails>(details,HttpStatus.CREATED);
		}
		
	}
	
}
