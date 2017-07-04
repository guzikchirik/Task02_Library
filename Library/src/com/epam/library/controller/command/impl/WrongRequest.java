package com.epam.library.controller.command.impl;

import com.epam.library.controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(String request) {
		System.out.println("Попал в wrongRequest:(");
		return null;
	}

}
