package com.kdt.oop.service;

import com.kdt.oop.view.HmsFrontView;

public class HmsApp {

	public static void main(String[] args) {
		/*
		HmsFront front = new HmsFront();
			
		front.mainMenu();
		*/
		HmsFrontView front = new HmsFrontView();
		front.mainMenu();
	}

}
