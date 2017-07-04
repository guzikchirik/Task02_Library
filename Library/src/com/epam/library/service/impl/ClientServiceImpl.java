package com.epam.library.service.impl;

import com.epam.library.bean.User;
import com.epam.library.dao.UserDAO;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.factory.DAOFactory;
import com.epam.library.service.ClientService;
import com.epam.library.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public void singIn(String login, String password)  throws ServiceException{
		
		if(login == null || login.isEmpty()){
			throw new ServiceException("Incorrect login");
		}		
		
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.singIn(login, password);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void singOut(String login) throws ServiceException{
		// TODO написать реализацию
	}

	@Override
	public void registration(User user) throws ServiceException {
		if(user.getName() == null || user.getSurname()== null || user.getName().isEmpty() || user.getSurname().isEmpty()){
			throw new ServiceException("Wrong name or Surname");
		}		
		
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.registration(user);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
