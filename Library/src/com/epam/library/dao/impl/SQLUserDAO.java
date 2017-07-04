package com.epam.library.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.library.bean.User;
import com.epam.library.dao.UserDAO;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.tools.DataBaseTools;

public class SQLUserDAO implements UserDAO {
	DataBaseTools dataBaseTools = DataBaseTools.getInstance();

	@Override
	public void singIn(String login, String password) throws DAOException{
		String request = "SELECT `init_id`, `init_login`, `init_password` FROM `initialization`";
//				+ "JOIN `m2m_books_authors` USING(`b_id`) "
//				+ "JOIN `authors` USING(`a_id`) "
//				+ "JOIN `m2m_books_genres` USING(`b_id`) "
//				+ "JOIN `genres` USING(`g_id`)";	
		ResultSet resultSet = dataBaseTools.getDBData(request);	
		
		try {
			while(resultSet.next()){
				if(login.equals(resultSet.getString(2))&&password.equals(resultSet.getString(3))){
					System.out.println("true");
				}else{
					System.out.println("false");
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void registration(User user) throws DAOException{
		String query = "INSERT INTO `users` (`u_name`, `u_surname`, `u_access`) VALUES ('" + user.getName() +"', '" + user.getSurname() +"','U')";
//		ResultSet resultSet = dataBaseTools.getDBData(request);	//TODO “ут скорее всего нужно сначала добавл€ть логин и пароль, а потом только им€ и фамилию юзера 
		Integer affected_rows = this.dataBaseTools.changeDBData(query);
		
		// ≈сли добавление прошло успешно...
		if (affected_rows > 0)
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
//		dataBaseTools.changeDBData(query);	
		
	}

}
