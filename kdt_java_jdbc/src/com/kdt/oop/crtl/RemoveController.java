package com.kdt.oop.crtl;

import com.kdt.oop.logic.HmsBackService;

public class RemoveController {
	private HmsBackService service;
	
	public RemoveController() {
		service = new HmsBackService();
	}

	public boolean execute(String name) {
		return service.removeProcess(name);
	}
}
