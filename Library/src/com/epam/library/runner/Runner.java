package com.epam.library.runner;

import com.epam.library.controller.Controller;


public class Runner {

	public static void main(String[] args) {	
		String command = "REGISTRATION";
		String login = "person6", password = "person8";
		String request = command.concat(" ").concat(login).concat(" ").concat(password);
		Controller contr = new Controller();
		System.out.println(contr.executeTask(request));
	}
}
