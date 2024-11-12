package test.dao;

import test.domain.RequestJoinDTO;

public class JoinDao {

	
	public JoinDao() {
		
	}
	
	public String joinRow(RequestJoinDTO params) {
		if(params.getId().equals("jlism") && params.getPwd().equals("jlism")
			&& params.getName().equals("jlism") && params.getGender().equals("man")) {
			
			return "회원가입을 환영합니다";
		} else 
			return null;
	}
	
}
