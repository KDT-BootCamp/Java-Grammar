package com.kdt.exp;

import com.kdt.except.ExceptionDemo;

public class ExceptionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main Start");
		/*
		String [] strAry = new String[] {
				"SW", "JAVA", "PYTHON", "JDBC"
				,"ORM"
		};

		System.out.println("ary length : " + strAry.length);

		try {
			System.out.println("예외 발생 코드 시작");
			for(int idx = 0; idx <= strAry.length; idx++) {
			System.out.println(strAry[idx]);
			}
			System.out.println("예외 발생 코드 종료");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생 대응 코드");
			e.printStackTrace();
		} finally {
			System.out.println("예외 발생 여부와 관계 없는 코드 시작");
			System.out.println("예외 발생 여부와 관계 없는 코드 종료");
		}
		System.out.println();
		*/
		/*
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		System.out.print("메뉴 번호를 입력하세요  : ");
		try{
		number = scanner.nextInt();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("input number : " + number);
		 */
		//int result = 0;
		ExceptionDemo ex = new ExceptionDemo();
		/*
		result = ex.runtime();
		System.out.println("result = " + result);
		*/
		
		/*String str = null;
		try {
			str = ex.compile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(str);
		*/
		try {
		ex.first(0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("main end");
		
	}
	
}
