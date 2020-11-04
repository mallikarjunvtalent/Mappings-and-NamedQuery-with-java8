package com.details.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.entity.EmployeeDetails;

public interface EmployeeDao  extends JpaRepository<EmployeeDetails, Integer>{

	EmployeeDetails findByUserId(int id);

	
	
}
