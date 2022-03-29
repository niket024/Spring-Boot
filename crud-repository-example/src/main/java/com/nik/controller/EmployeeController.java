package com.nik.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/hello")
	public String hello() {
		LOGGER.info("Testing application");
		return "Its working";
	}

	@PostMapping("/create")
	public String createEmployee(@RequestBody Employee employee) {
		LOGGER.info("Saving employee {}", employee);
		employeeService.save(employee);
		return "Employee saved successfully";
	}

	@GetMapping("/getallemployee")
	public List<Employee> getAllEmployee() {
		LOGGER.info("Fetching all employee");
		return employeeService.getAllEmployee();
	}
}
