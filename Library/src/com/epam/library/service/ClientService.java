package com.epam.library.service;

import com.epam.library.bean.User;
import com.epam.library.service.exception.ServiceException;

public interface ClientService {
	void signIn(String login, String password) throws ServiceException;
	void signOut(String login) throws ServiceException;
	void registration(User user) throws ServiceException;	
}
