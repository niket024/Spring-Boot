package com.nik;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
 
@Service
public class StudentService
{
    @Cacheable("student")
    public Student getStudentByID(String id)
    {
        System.out.println("I am from getStudentByID");

		/*
		 * try {
		 * System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
		 * Thread.sleep(1000*5); } catch (InterruptedException e) { e.printStackTrace();
		 * }
		 */
        return new Student(id,"Sajal" ,"V");
    }
}
