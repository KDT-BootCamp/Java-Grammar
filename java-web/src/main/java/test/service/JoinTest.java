package test.service;

import test.dao.JoinDao;
import test.domain.RequestJoinDTO;

public class JoinTest {
	
	private JoinDao dao ;
	
	public JoinTest() {
		dao = new JoinDao();
	}
	
	public String join(RequestJoinDTO params) {
		System.out.println("debug >>> service join params = " + params);
		return dao.joinRow(params);
	}
	
}
