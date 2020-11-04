package com.details.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.details.entity.Department;

public interface OneToManyDeptmentDao extends JpaRepository<Department, Integer> {

	Department findByDepartmentName(String departmentName);

	@Transactional
	void deleteByDepartmentName(String departmentName);

}
