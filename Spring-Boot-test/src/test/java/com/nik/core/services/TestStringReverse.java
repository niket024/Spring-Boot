package com.nik.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringReverse {
	StringReverse reverse = null;

	@BeforeEach
	public void init() {
		reverse = new StringReverse();
	}

	@Test
	public void testNullValue() {
		assertEquals(null, reverse.getReverse(null));
	}

	@Test
	public void testEmptyValue() {
		assertEquals("", reverse.getReverse(""));
	}

	@Test
	public void testReverse() {
		assertEquals("cba", reverse.getReverse("abc"));
	}
}
