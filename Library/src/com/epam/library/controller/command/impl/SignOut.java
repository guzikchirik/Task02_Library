package com.epam.library.controller.command.impl;

import com.epam.library.controller.command.Command;

public class SignOut implements Command {

	@Override
	public String execute(String request) {
		// TODO может просто поменять у userа signin на false
		return null;
	}

}
