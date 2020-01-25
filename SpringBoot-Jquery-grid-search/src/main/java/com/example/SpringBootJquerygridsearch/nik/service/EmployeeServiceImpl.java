package com.example.SpringBootJquerygridsearch.nik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootJquerygridsearch.nik.model.Employee;
import com.example.SpringBootJquerygridsearch.nik.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.getOne(id);
	}
	@Override
	public List<Employee> getEmployeeByName(String name) {
		return employeeRepository.findByPlaceContaining(name);
	}
	

}