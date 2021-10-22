package com.demo.exceptions;

public class SomeException extends Exception{
    public SomeException() {}

	public SomeException(String m) {
		super(m);
	}
	public SomeException(Exception e) {
		super(e);
	}
	public SomeException(String m, Exception e) {
		super(m, e);
	}
}