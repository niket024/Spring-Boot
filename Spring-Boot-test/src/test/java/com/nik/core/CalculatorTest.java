package com.nik.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		int actual = Calculator.add(2, -3);
		assertEquals(-1, actual);
	}
	
}
