package com.nik.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.dao.EmployeeDao;
import com.nik.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);

	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<>();
		Iterable<Employee> all = employeeDao.findAll();
		for (Employee emp : all) {
			employees.add(emp);
		}
		return employees;
	}

}
