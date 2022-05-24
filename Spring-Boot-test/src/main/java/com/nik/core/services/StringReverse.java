package com.nik.core.services;

public class StringReverse {
	public String getReverse(String input) {
		if (input != null && input.length() > 0) {
			return new StringBuilder(input).reverse().toString();
		}
		System.out.println("given input is null or empty");
		return input;
	}
}


