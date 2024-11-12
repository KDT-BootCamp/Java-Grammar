package com.kdt.oop;

import com.kdt.oop.util.HmsType;

public class StudentVO extends PersonVO{

	private String stuId;
	
	public StudentVO() {
		
	}
	
	
	public String showInfo() {
		return 	super.perInfo() + ", stuId = " + stuId;
	}


	public StudentVO(HmsType type,String name, int age, String address, String stuId) {
		super();
		super.setType(type);
		super.setName(name);
		super.setAge(20);
		super.setAddress(address);
		setStuId(stuId);
	}
	
	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
	public String perInfo() {
		return super.perInfo() + ", stuId = " + stuId;
	}
	
	public String info() {
		return "stu-" + super.info()  + "-" + stuId;
	}
	
	
}
