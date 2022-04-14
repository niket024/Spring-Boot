package com.nik.exception;

public class DBOperationFailedException extends RuntimeException {
	private String msg;

	public DBOperationFailedException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
