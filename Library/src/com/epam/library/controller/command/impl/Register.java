package com.epam.library.controller.command.impl;

import com.epam.library.bean.User;
import com.epam.library.controller.command.Command;
import com.epam.library.service.ClientService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;

public class Register implements Command {
	User user;
	@Override
	public String execute(String request) {
		
		String[] param = request.split(" ");
		String name = param[1];
		String surname = param[2];
		String response = null;
		user = new User(name,surname);
		
		System.out.println(name);
		System.out.println(surname);
		System.out.println(response);
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();
		try {
			clientService.registration(user);
			response = "New USER added!";
		} catch (ServiceException e) {
			// TODO Write log
			response = "Error duiring login procedure";
		}
				
		return response;
	}

}
