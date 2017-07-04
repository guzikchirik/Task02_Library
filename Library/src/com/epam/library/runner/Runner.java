package com.epam.library.runner;

import com.epam.library.controller.Controller;


public class Runner {

	public static void main(String[] args) {	
		String registration = "REGISTRATION";
		String showAllBooks = "show_all_books";
		String addBook = "add_book";
		
//		String name = "Alexsandr";
//		String surName = "Pushkin";
		String login = "Alexsandr", password = "798321";
		String title = "MyBook"; 
		String author = "Chyrko";
		String genre = "Programming";
		int year = 2017;
		int quantity = 10;
//		String request = showAllBooks+" "+login+" "+password;
		String request = addBook+" "+title+" "+author+" "+genre+" "+year+" "+quantity;
		Controller contr = new Controller();
		System.out.println(contr.executeTask(request));
	}
}
