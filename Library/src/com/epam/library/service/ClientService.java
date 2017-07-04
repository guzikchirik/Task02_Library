package com.epam.library.service;

import com.epam.library.bean.User;
import com.epam.library.service.exception.ServiceException;

public interface ClientService {
	void singIn(String login, String password) throws ServiceException;
	void singOut(String login) throws ServiceException;
	void registration(User user) throws ServiceException;	
}
