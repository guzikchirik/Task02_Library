package com.epam.library.controller.command.impl;

import com.epam.library.bean.Book;
import com.epam.library.controller.command.Command;

import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;

public class AddBook implements Command {
	Book book;
	@Override
	public String execute(String request) {
		String[] param = request.split(" ");		
		String title = param[1];
		String author = param[2];
		String genre = param[3];
		int year = Integer.parseInt(param[4]);
		int quantity = Integer.parseInt(param[5]);
		book = new Book(title,author,genre,year,quantity);
		String response = null;
//		user = new User(login,password);
		System.out.println(title);
		System.out.println(author);
		System.out.println(genre);
		System.out.println(year);
		System.out.println(quantity);
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		LibraryService libraryService = serviceFactory.getLibraryService();
		try {
			libraryService.addNewBook(book);
			response = "New Book added!";
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			response = "Smth wrong";
		}
				
		return response;
	}

}
