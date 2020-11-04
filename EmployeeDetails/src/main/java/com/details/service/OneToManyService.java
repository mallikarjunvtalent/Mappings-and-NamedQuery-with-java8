package com.details.service;

import java.util.List;
import java.util.Optional;

import com.details.entity.Department;

public interface OneToManyService {

	Department save(Department department);

	List<Department> getAllDetails();

	Optional<Department> getByIdDetails(int id);

	Department findByDepartmentName(String departmentName);

	void deleteByDepartmentName(String departmentName);



}
