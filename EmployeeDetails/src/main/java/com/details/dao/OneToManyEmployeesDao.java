package com.details.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.details.entity.Employees;

public interface OneToManyEmployeesDao extends JpaRepository<Employees, Integer>{

	@Query(value="from Employees e where e.name like :type%")
	List<Employees> getStartsWithName( String type);

	@Query(value="from Employees e where e.name like %:name")
	List<Employees> getEndsWithName(@Param("name")String name);

	@Query(value="from Employees e where e.name like %:name%")
	List<Employees> getMiddleLetters(String name);

	List<Employees> getStartsWithNameQuery();

	List<Employees> getWithName(String name);

	List<Employees> getWithIdAndJob(int id, String job);

}
