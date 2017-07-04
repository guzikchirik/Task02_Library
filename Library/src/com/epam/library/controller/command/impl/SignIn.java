package com.epam.library.controller.command.impl;

import com.epam.library.controller.command.Command;
import com.epam.library.service.ClientService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;

public class SignIn implements Command {

	@Override
	public String execute(String request) {
		String[] param = request.split(" ");
		String login = param[1];
		String password = param[2];
		String response = null;
		System.out.println(login);
		System.out.println(password);
//		System.out.println(response);
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();
		try {
			clientService.signIn(login, password);
			response = "Welcom!";
		} catch (ServiceException e) {
			// TODO Write log
			response = e.getMessage();
		}
				
		return response;
	}

}
