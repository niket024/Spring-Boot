package com.example.SpringBootJquerygridsearch.nik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SpringBootJquerygridsearch.nik.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE lower(e.name) like lower(concat('%', :searchTerm,'%'))")
	public List<Employee> findByPlaceContaining(@Param("searchTerm") String name);

}