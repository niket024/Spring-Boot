package com.nik.service;

import java.util.List;

import com.nik.model.Employee;

public interface EmployeeService {
	void save(Employee employee);
	List<Employee> getAllEmployee();
}
