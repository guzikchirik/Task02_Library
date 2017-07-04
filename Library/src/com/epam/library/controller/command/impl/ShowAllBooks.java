package com.epam.library.controller.command.impl;

import com.epam.library.controller.command.Command;
import com.epam.library.service.ClientService;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;

public class ShowAllBooks implements Command {

	@Override
	public String execute(String request) {
		String response;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LibraryService libraryService = serviceFactory.getLibraryService();
		try {
			libraryService.showAllBooks();
			response = "New USER added!";
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			response = "Error duiring login procedure";
		}
		return null;	
	}

}
