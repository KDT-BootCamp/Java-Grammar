package com.kdt.oop;

import com.kdt.oop.util.HmsType;

public class TeacherVO extends PersonVO{
	private String subject;
		
	public TeacherVO() {
	}

	public TeacherVO(HmsType type,String name, int age, String address, String subject) {
		super();
		super.setType(type);
		super.setName(name);
		super.setAge(20);
		super.setAddress(address);
		setSubject(subject);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}	

	public String perInfo() {
		return 	super.perInfo() + ", subject = " + subject;
	}
	
	public String info() {
		return "tea-" + super.info()  + "-" + subject;
	}
}
