package com.kdt.oop;

import com.kdt.oop.util.HmsType;

public class EmployeeVO extends PersonVO{

	private String dept;
	
	public EmployeeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeVO(HmsType type,String name, int age, String address, String dept) {
		super();
		super.setType(type);
		super.setName(name);
		super.setAge(20);
		super.setAddress(address);		
		setDept(dept);
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	public String perInfo() {
		return 	super.perInfo() + ", dept = " + dept;
	}
	
	public String info() {
		return "emp-" + super.info()  + "-" + dept;
	}

}
