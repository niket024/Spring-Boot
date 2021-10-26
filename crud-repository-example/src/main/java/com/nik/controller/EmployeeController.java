package com.nik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nik.model.Employee;
import com.nik.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/hello")
	public String hello() {
		return "Its working";
	}

	@PostMapping("/create")
	public String createEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "Employee saved successfully";
	}

	@GetMapping("/getallemployee")
	public List<Employee> getAllEmployee() {

		return employeeService.getAllEmployee();
	}
}
