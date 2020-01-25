package com.nik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class StudentController
{
 
    @Autowired
    StudentService studentService;
 
    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable String id)
    {
        System.out.println("Searching by ID  : " + id);
 
        return studentService.getStudentByID(id);
    }
}