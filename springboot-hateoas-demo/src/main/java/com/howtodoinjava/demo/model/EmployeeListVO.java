package com.howtodoinjava.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class EmployeeListVO extends ResourceSupport implements Serializable
{
    private static final long serialVersionUID = 1L;
      
    private List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
  
    public List<EmployeeVO> getEmployees() {
        return employees;
    }
  
    public void setEmployees(List<EmployeeVO> employees) {
        this.employees = employees;
    }
}