package com.accenture.lkm.exceptions;

@SuppressWarnings("serial")
public class InvalidDummyException extends Exception {
	public InvalidDummyException() {
		super("It is a Dummy checked exception");
	}

}
