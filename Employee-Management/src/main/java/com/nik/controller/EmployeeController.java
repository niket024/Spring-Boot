package com.nik.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nik.modal.Employee;
import com.nik.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	private static List<Employee> employees = createList();

	@GetMapping(produces = "application/json")
	public List<Employee> firstPage() {
		return employeeService.getAllEmployees();
	}

	@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") Integer id) {
		employeeService.deleteEmployeeById(id);
		return null;
	}

	@GetMapping(path = { "/{id}" })
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeService.findEmployeeById(id);
	}

	@PostMapping
	public Employee create(@RequestBody Employee emp) {
		employeeService.createEmployee(emp);
		return emp;
	}

	@PutMapping
	public Employee update(@RequestBody Employee emp) {
		System.out.println("update");
		employeeService.updateEmployee(emp);
		return emp;
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId(1l);
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId(2l);
		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}

}
