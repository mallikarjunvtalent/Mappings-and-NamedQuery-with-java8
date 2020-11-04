package com.details.service;

import java.util.List;
import java.util.Optional;

import com.details.entity.Address;
import com.details.entity.EmployeeDetails;

public interface EmployeeService {

	EmployeeDetails save(EmployeeDetails details);

	List<EmployeeDetails> findAll();

	EmployeeDetails findByUserId(int id);

	

}
