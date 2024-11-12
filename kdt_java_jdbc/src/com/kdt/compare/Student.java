package com.kdt.compare;

import java.util.Comparator;

public class Student implements Comparator<Student>{
	
	private int age;
	private int classNumber;
	
	public Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	@Override
	public int compare(Student o1,Student o2) {
		return o1.getClassNumber() - o2.getClassNumber();
	}
}
