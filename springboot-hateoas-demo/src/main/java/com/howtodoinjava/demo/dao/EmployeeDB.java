package com.howtodoinjava.demo.dao;

import java.util.Arrays;
import java.util.List;

import com.howtodoinjava.demo.model.EmployeeVO;

public class EmployeeDB {
	 
    public static List<EmployeeVO> getEmployeeList()
    {
        
 
        EmployeeVO empOne = new EmployeeVO(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        EmployeeVO empTwo = new EmployeeVO(2, "Amit", "Singhal", "asinghal@yahoo.com");
        EmployeeVO empThree = new EmployeeVO(3, "Kirti", "Mishra", "kmishra@gmail.com");
        List<EmployeeVO> list = Arrays.asList(empOne,empTwo,empThree);
 
        return list;
    }
}
