package com.nik;

public class ProductNotfoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String msg;

	public ProductNotfoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

}