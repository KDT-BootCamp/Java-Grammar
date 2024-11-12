package test.dao;

import test.domain.RequestTestDTO;
import test.domain.ResponseTestDTO;

public class TestDao {
	
	private ResponseTestDTO response ;
	
	public TestDao () {	
		response = new ResponseTestDTO() ;
	}
	
	
	public ResponseTestDTO loginRow(RequestTestDTO params) {
		System.out.println("debug >>> dao loginRow params = " + params) ;
		if(params.getId().equals("jlism") && params.getPwd().equals("jlism")) {
			return response;
		} else {
			return null;
		}
	}

}	
