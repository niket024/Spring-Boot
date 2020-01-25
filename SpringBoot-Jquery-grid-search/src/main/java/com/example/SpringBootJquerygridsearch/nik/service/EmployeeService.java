package com.example.SpringBootJquerygridsearch.nik.service;

import java.util.List;

import com.example.SpringBootJquerygridsearch.nik.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(long id);
	public List<Employee> getEmployeeByName(String name);
	
}