package com.nik;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.nik.model.Employee;
import com.nik.model.Employees;


@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({ "schema.sql", "data.sql" })
	@Test
	public void testAllEmployees() {
		assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/employees", Employees.class)
				.getEmployeeList().size() == 3);
	}

	@Test
	public void testAddEmployee() {
		Employee employee = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/employees", employee, String.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
	}
}