package com.details.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.details.dao.OneToManyEmployeesDao;
import com.details.entity.Department;
import com.details.entity.Employees;
import com.details.exceptions.DetailsNotFoundException;
import com.details.service.OneToManyService;

@RestController
@RequestMapping("onetomany")
public class OneToManyController {

	@Autowired
	private OneToManyService oneToManyService;

	@Autowired
	private OneToManyEmployeesDao oneToManyEmployeesDao;

	@PostMapping("save")
	public Department saveDepartment(@RequestBody Department department) {

		department.setDepartmentId(0);
		return oneToManyService.save(department);
	}

	@PostMapping("saveemp")
	public Employees saveEmployees(@RequestBody Employees employees) {

		employees.setEmpId(0);
		return oneToManyEmployeesDao.save(employees);
	}

	@GetMapping("getAll")
	public List<Department> getAllDetails() {

		List<Department> departments = oneToManyService.getAllDetails();

		return departments;
	}

	@GetMapping("getbyLocation/{type}")
	public List<Department> getbyLocation(@PathVariable("type") String type) {

		List<Department> departments = oneToManyService.getAllDetails();

		return departments.stream().filter(dept -> {
			return dept.getLocation().equalsIgnoreCase(type);
		}).collect(Collectors.toList());
	}

	@GetMapping("getById/{id}")
	public Optional<Department> getByIdDetails(@PathVariable int id) {

		Optional<Department> optional = oneToManyService.getByIdDetails(id);

		return optional;
	}

	@PutMapping("/update")
	public Department updateCompany(@RequestBody Department department) {

		oneToManyService.save(department);

		return department;
	}

	@DeleteMapping("delete/{departmentName}")
	public String deleteData(@PathVariable("departmentName") String departmentName) {

		Department department = oneToManyService.findByDepartmentName(departmentName);

		if (department == null) {
			throw new RuntimeException("Employe Not Found -" + departmentName);
		}
		oneToManyService.deleteByDepartmentName(departmentName);
		return departmentName + " Department deleted ";
	}

	@GetMapping("getAllEmp")
	public List<Employees> getAllEmployeeDetails() {

		List<Employees> employees = oneToManyEmployeesDao.findAll();

		return employees;
	}

	@GetMapping("getStartsWithName/{name}")
	public List<Employees> getStartsWithName(@PathVariable("name") String name) {

		List<Employees> employees = oneToManyEmployeesDao.getStartsWithName(name);
		if (employees.isEmpty()) {
			throw new DetailsNotFoundException("Starts With letter " + name + " not found");
		} else {
			return employees;
		}
	}
	
	@GetMapping("getStartsWithNameQuery")
	public List<Employees> getStartsWithNameQuery() {

		List<Employees> employees = oneToManyEmployeesDao.getStartsWithNameQuery();
		if (employees.isEmpty()) {
			throw new DetailsNotFoundException("Starts With letter was not found");
		} else {
			return employees;
		}
	}

	@GetMapping("getEndsWithName/{name}")
	public List<Employees> getEndsWithName(@PathVariable("name") String name) {

		List<Employees> employees = oneToManyEmployeesDao.getEndsWithName(name);

		if (employees.isEmpty()) {

			throw new DetailsNotFoundException("Ends With letter " + name + " not found");
		} else {
			return employees;
		}
	}
	
	@GetMapping("getMiddleLetters/{name}")
	public List<Employees> getMiddleLetters(@PathVariable("name") String name) {

		List<Employees> employees = oneToManyEmployeesDao.getMiddleLetters(name);

		if (employees.isEmpty()) {

			throw new DetailsNotFoundException("letters " + name + " not found");
		} else {
			return employees;
		}
	}
	
	@GetMapping("getWithName/{name}")
	public List<Employees> getWithName(@PathVariable("name") String name) {

		List<Employees> employees = oneToManyEmployeesDao.getWithName(name);

		if (employees.isEmpty()) {

			throw new DetailsNotFoundException(  name + " not found");
		} else {
			return employees;
		}
	}
	
	@GetMapping("getWithIdAndJob/{id}/{job}")
	public List<Employees> getWithIdAndJob(@PathVariable int id,@PathVariable("job") String job) {

		List<Employees> employees = oneToManyEmployeesDao.getWithIdAndJob(id,job);

		if (employees.isEmpty()) {

			throw new DetailsNotFoundException(" not found");
		} else {
			return employees;
		}
	}

	@GetMapping("getSalaryLessThan")
	public List<Employees> getAllWithJava8Details() {

		List<Employees> employees = oneToManyEmployeesDao.findAll();

		return employees.stream().filter(emp -> {
			return emp.getSalary() < 25000;
		}).collect(Collectors.toList());
	}

	@GetMapping("getWithJobType/{type}")
	public List<Employees> getDetailsWithJobType(@PathVariable("type") String type) {

		List<Employees> employees = oneToManyEmployeesDao.findAll();

		return employees.stream().filter(emp -> {
			return emp.getJob().equalsIgnoreCase(type);
		}).collect(Collectors.toList());
	}

//	@GetMapping("getSalary")
//	public List<Employees> getSalaryDetails() {
//
//		List<Employees> employees = oneToManyEmployeesDao.findAll();
//
//		List<Employees> emp = employees.stream().filter(emp -> {
//			return emp.getSalary() < 25000;}).map(emp -> emp.getSalary();)
//				.collect(Collectors.toList());
//	}
}
