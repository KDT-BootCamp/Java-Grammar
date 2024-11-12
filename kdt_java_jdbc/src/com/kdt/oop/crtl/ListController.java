package com.kdt.oop.crtl;

import java.util.List;

import com.kdt.oop.PersonVO;
import com.kdt.oop.logic.HmsBackService;

public class ListController {
	private HmsBackService service;
	
	public ListController() {
		service = new HmsBackService() ;
		
	}

	public List<PersonVO> execute(){
		return 	service.list();
	}
}
