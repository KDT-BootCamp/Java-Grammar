package com.kdt.except;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.kdt.exp.RecordNotFoundException;

public class ExceptionDemo {

	public int runtime() throws Exception{
		int result = 0;
		result = 10 / 0;
		return result;
		
	}
	
	public String compile() throws Exception {
		String str = null;
		System.out.print("문자를 입력하세요 : ");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		str = br.readLine();
		return str;
	}
	public void first(int flag) throws Exception{
		System.out.println(">>> first start");
		try {
		second(flag);
		}
		finally {
		System.out.println(">>> first end");
		}
	}
	
	public void second(int flag) throws Exception{
		System.out.println(">>> second start");
		try {
		third(flag);
		} 
		finally {
		System.out.println(">>> second end");
		}
	}

	public void third(int flag) throws Exception{
		System.out.println(">>> third start");
		try {
		if(flag == 0) {
			throw new RecordNotFoundException("찾는 데이터가 맞지 않습니다.");
			}
		} finally {
		System.out.println(">>> third end");
			}
		}
	}
