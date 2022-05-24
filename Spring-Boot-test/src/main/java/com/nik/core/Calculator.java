package com.nik.core;

public class Calculator {
	static String name;
	
	public static void setName(String name) {
		Calculator.name = name;
	}
	
	public static String getName() {
		return name;
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static void test()
	{
		System.out.println("test");
		
	}
}

