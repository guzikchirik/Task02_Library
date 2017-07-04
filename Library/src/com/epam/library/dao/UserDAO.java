package com.epam.library.dao;

import com.epam.library.bean.User;
import com.epam.library.dao.exception.DAOException;

public interface UserDAO {
	void singIn(String login, String password) throws DAOException;
	void registration(User user) throws DAOException;
}
