package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.assignment.springboot.mongo.model.Employee;

public interface Employeeservice {

	public void createEmployee(List<Employee> emp);

	public Collection<Employee> getAllEmployees();

	public Optional<Employee> findEmployeeById(int id);

	public void deleteEmployeeById(int id);

	public void updateEmployee(Employee emp);

	public void deleteEmployee(Employee emp);

	public void deleteAllEmployees();
}