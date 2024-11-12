package com.kdt.exp;

public class RecordNotFoundException extends Exception{

	public RecordNotFoundException() {
		
	}
	
	public RecordNotFoundException(String errMsg) {
		super(errMsg);
	}
}
