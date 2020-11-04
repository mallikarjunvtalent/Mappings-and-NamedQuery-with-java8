package com.details.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.details.dao.OneToManyDeptmentDao;
import com.details.entity.Department;

@Service
public class OneToManyServiceImpl implements OneToManyService {

	@Autowired
	private OneToManyDeptmentDao oneToManyDeptmentDao;
	
	@Override
	public Department save(Department department) {
		return oneToManyDeptmentDao.save(department);
	}

	@Override
	public List<Department> getAllDetails() {
		return oneToManyDeptmentDao.findAll();
	}

	@Override
	public Optional<Department> getByIdDetails(int id) {
		return oneToManyDeptmentDao.findById(id);
	}

	@Override
	public Department findByDepartmentName(String departmentName) {
		return oneToManyDeptmentDao.findByDepartmentName(departmentName);
	}

	@Override
	public void deleteByDepartmentName(String departmentName) {
		oneToManyDeptmentDao.deleteByDepartmentName(departmentName);
	}

	

}
