package com.nik.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void testNegativeAdd() {
		int actual = Calculator.add(2, -3);
		assertEquals(-1, actual);
	}
	
	@Test
	public void testPositiveAdd() {
		int actual = Calculator.add(2, 3);
		assertEquals(5, actual);
	}
	
	@Test
	public void testSetName() {
		Calculator.setName("abc");
		assertEquals("abc", Calculator.getName());
	}
	
}
