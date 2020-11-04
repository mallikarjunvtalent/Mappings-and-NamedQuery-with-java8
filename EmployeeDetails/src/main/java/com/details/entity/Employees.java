package com.details.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity

@NamedQueries({
	@NamedQuery(name="Employees.getStartsWithNameQuery", query="from Employees e where e.name like 's%'"),
	@NamedQuery(name="Employees.getWithName", query="from Employees e where e.name like :name") ,
	@NamedQuery(name="Employees.getWithIdAndJob", query="from Employees e where e.empId =:id and e.job =: job")
})
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String name;
	private String job;
	private double salary;
	private String email;
	
	@ManyToOne
	private Department department;

	public Employees() {
		 
	}

	 
	public int getEmpId() {
		return empId;
	}

	 
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	 
	public String getName() {
		return name;
	}

	 
	public void setName(String name) {
		this.name = name;
	}

	 
	public double getSalary() {
		return salary;
	}

	 
	public void setSalary(double salary) {
		this.salary = salary;
	}

	 
	public String getEmail() {
		return email;
	}

	 
	public void setEmail(String email) {
		this.email = email;
	}

	 
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}


	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", name=" + name + ", job=" + job + ", salary=" + salary + ", email="
				+ email  + "]";
	}


	
	
	
}
