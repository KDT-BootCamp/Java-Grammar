package com.kdt.oop;

import java.io.Serializable;

import com.kdt.oop.util.HmsType;

public class PersonVO implements Serializable{
	private String name;
	private int age;
	private String address;
	private HmsType type;
	public PersonVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonVO(HmsType type,String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public HmsType getType() {
		return type;
	}
	public void setType(HmsType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String perInfo() {
		return "NAME = " + name + ", AGE = " + age + ", ADDRESS = " + address ;
	}
	public String info() {
		return name + "-" + age + "-" + address ;
	}

}
