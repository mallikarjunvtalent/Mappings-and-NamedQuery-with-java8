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

@RestController
@RequestMapping("address")
public class AddressController {

	private static final Logger LOGGER = LogManager.getLogger(AddressController.class);
	
	
	
	@Autowired
	private AddressDao addressDao;
	
	@GetMapping("/getAll") ResponseEntity<List<Address>> getAllCustomers() {
		List<Address> list = addressDao.findAll();
		LOGGER.info("List Of Customers:"+list);
		return new ResponseEntity<List<Address>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
	@GetMapping("getById/{id}")
	public Optional<Address> getById(@PathVariable int id) throws Exception{
		
		Optional<Address> address = addressDao.findById(id);
		
		if (address == null) {
			throw new DetailsNotFoundException("Details not founded " +id);
		} else {
			return address;	
		}
	}
	
}

