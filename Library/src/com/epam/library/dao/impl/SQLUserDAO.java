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
		String request = "SELECT `u_id`, `u_login`, `u_password`, `u_access`, `u_signIn` FROM `users`";	
		String query; 
		ResultSet resultSet = dataBaseTools.getDBData(request);	
		
		try {
			
				while(resultSet.next()){
					if("OUT".equals(resultSet.getString(5))){
						if(login.equals(resultSet.getString(2))&&password.equals(resultSet.getString(3))){
							query = "UPDATE users SET u_signIn='IN' WHERE u_id = "+resultSet.getInt(1)+"";
							dataBaseTools.changeDBData(query);
						}				
					}else{
						if(login.equals(resultSet.getString(2))&&password.equals(resultSet.getString(3))){
//							System.out.println("User already SignIn!");
							throw new DAOException("User already SignIn!");
							
						}
					}
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void registration(User user) throws DAOException{	
		
		String request = "SELECT  `u_login`, `u_password` FROM `users`";
		String query = "INSERT INTO `users` (`u_login`, `u_password`, `u_access`) VALUES ('"+ user.getLogin() +"', '" + user.getPassword() +"','U')";
		ResultSet resultSet = dataBaseTools.getDBData(request);	
		try {
			while(resultSet.next()){
				if(user.getLogin().equals(resultSet.getString(1))){					
					throw new DAOException("User with such login already exists!");
				}else if(user.getPassword().equals(resultSet.getString(2))){
					throw new DAOException("User with such password already exists!");
				}				
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		Integer affected_rows = this.dataBaseTools.changeDBData(query);
		// ���� ���������� ������ �������...
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
