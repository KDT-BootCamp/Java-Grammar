package com.kdt.oop.crtl;


import com.kdt.oop.PersonVO;
import com.kdt.oop.logic.HmsBackService;

public class UpdateController {

	private HmsBackService service;
	
	public UpdateController() {
		service = new HmsBackService();
	}
	
	public PersonVO execute(String name) {
		return service.searchProcess(name);
	}

	public void execute(PersonVO person) {
		service.updateProcess(person);
	}
}
