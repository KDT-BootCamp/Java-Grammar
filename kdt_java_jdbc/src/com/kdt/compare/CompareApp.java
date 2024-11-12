package com.kdt.compare;

public class CompareApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu01 = new Student(20,1);
		Student stu02 = new Student(30,2);
		Student stu03 = new Student(40,3);
	
		int isBig = stu01.compare(stu02,stu03);
		
		System.out.println( (isBig > 0) ? "mtrue" : 
			((isBig == 0) ? "equal" : "false"));
	}
}
