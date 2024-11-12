package com.kdt.oop.crtl;

import com.kdt.oop.logic.HmsBackService;
import com.kdt.oop.util.HmsType;

public class InsertController {
	private HmsBackService service;
	
	public InsertController() {
		service = new HmsBackService();
	}

	public String execute(HmsType type, String name, int age, String address, String common) {
		return  service.createRequest(type,name,age,address,common);
	}
}
