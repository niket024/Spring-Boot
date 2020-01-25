package com.example.SpringBootJquerygridsearch.nik.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJquerygridsearch.nik.model.Employee;
import com.example.SpringBootJquerygridsearch.nik.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public List<Employee> getEmployeeById(@PathVariable("id") long id) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employeeService.getEmployeeById(id));
		return employees;
	}

	@RequestMapping(value = "/employee/name={empName}", method = RequestMethod.GET)
	public List<Employee> getEmployeeByNAme(@PathVariable("empName") String name) {

		return employeeService.getEmployeeByName(name);
	}

}