package com.details.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.details.dao.AddressDao;
import com.details.dao.EmployeeDao;
import com.details.entity.Address;
import com.details.entity.EmployeeDetails;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	
	
	@Override
	public EmployeeDetails save(EmployeeDetails details) {
		return employeeDao.save(details);
	}

	@Override
	public List<EmployeeDetails> findAll() {
		return employeeDao.findAll();
	}


	@Override
	public EmployeeDetails findByUserId(int id) {
		return employeeDao.findByUserId(id);
	}
	

}
