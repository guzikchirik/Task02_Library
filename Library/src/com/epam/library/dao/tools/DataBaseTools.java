package com.epam.library.dao.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTools {
	private static DataBaseTools instance = null;
	//  оличество р€дов таблицы, затронутых последним запросом.
		private Integer affected_rows = 0;
		
		// «начение автоинкрементируемого первичного ключа, полученное после
		// добавлени€ новой записи.
		private Integer last_insert_id = 0;
	
	public static DataBaseTools getInstance(){
		if (instance == null)
		{
			instance = new DataBaseTools();
		}	
		return instance;
	}
	
	private DataBaseTools(){}
	
	public ResultSet getDBData(String query)
	{
		Statement statement;
		Connection connect;
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost/library_ver2?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&useSSL=false&connectionCollation=utf8_general_ci");
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			return resultSet;
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			System.out.println(e+"my");
		}
		
		System.out.println("null on getDBData()! my");
		return null;
	}
	
	public Integer changeDBData(String query)
	{
		Statement statement;
		Connection connect;
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost/library_ver2?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&useSSL=false&connectionCollation=utf8_general_ci");
			statement = connect.createStatement();
			this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		
			// ѕолучаем last_insert_id() дл€ операции вставки.
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
            	this.last_insert_id = rs.getInt(1);
            }
			
			return this.affected_rows;
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("null on changeDBData()!");
		return null;
	}
}
