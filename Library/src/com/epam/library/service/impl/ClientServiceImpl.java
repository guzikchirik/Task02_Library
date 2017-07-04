package com.epam.library.service.impl;

import com.epam.library.bean.User;
import com.epam.library.dao.UserDAO;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.factory.DAOFactory;
import com.epam.library.service.ClientService;
import com.epam.library.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public void signIn(String login, String password)  throws ServiceException{
		
		if(login == null || login.isEmpty()){
			throw new ServiceException("Incorrect login");
		}		
		
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.singIn(login, password);
		} catch (DAOException e) {
//			System.out.println(e.getMessage());
			throw new ServiceException(e.getMessage());
		}		

	}

	@Override
	public void signOut(String login) throws ServiceException{	
		// TODO написать реализацию
	}

	@Override
	public void registration(User user) throws ServiceException {
		if(user.getLogin() == null || user.getPassword()== null || user.getLogin().isEmpty() || user.getPassword().isEmpty()){		
			throw new ServiceException("Wrong name or Surname");
		}				
		
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.registration(user);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
