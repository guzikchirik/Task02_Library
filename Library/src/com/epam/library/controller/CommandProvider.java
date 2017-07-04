package com.epam.library.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.library.controller.command.Command;
import com.epam.library.controller.command.CommandName;
import com.epam.library.controller.command.impl.AddBook;
import com.epam.library.controller.command.impl.Register;
import com.epam.library.controller.command.impl.ShowAllBooks;
import com.epam.library.controller.command.impl.SignIn;
import com.epam.library.controller.command.impl.WrongRequest;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider() {
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.REGISTRATION, new Register());
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.SHOW_ALL_BOOKS, new ShowAllBooks());
		
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	Command getCommand(String name){
		CommandName commandName = null;
		Command command = null;
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		
		return command;		
	}
}
