package com.keysoft.bucktrackerjpa.exception;

public class NoApplicationFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String msg;

	public NoApplicationFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
