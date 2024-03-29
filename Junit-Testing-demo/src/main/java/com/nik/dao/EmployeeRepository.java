package com.nik.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nik.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
