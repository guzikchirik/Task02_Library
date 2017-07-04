package com.epam.library.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.library.bean.Book;
import com.epam.library.dao.BookDAO;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.tools.DataBaseTools;

public class SQLBookDAO implements BookDAO{
	
	DataBaseTools dataBaseTools = DataBaseTools.getInstance();

	@Override
	public void addBook(Book book) throws DAOException{
		String queryInBooks = "INSERT INTO `books` (`b_name`, `b_year`, `b_quantity`) VALUES ('"
				+ book.getTitle()+"', '" + book.getYear() +"','" +book.getQuantity() + "')";
		String queryInAuthors = "INSERT INTO `authors` (`a_name`) VALUES ('"+ book.getAuthor()+"')";
		String queryInGenres = "INSERT INTO `genres` (`g_name`) VALUES ('"+ book.getGenre()+"')";
		
		Integer affected_rows1 = this.dataBaseTools.changeDBData(queryInBooks);
		int b_id = dataBaseTools.last_insert_id;
		
		
		Integer affected_rows2 = this.dataBaseTools.changeDBData(queryInAuthors);
		int a_id = dataBaseTools.last_insert_id;
		
		Integer affected_rows3 = this.dataBaseTools.changeDBData(queryInGenres);
		int g_id = dataBaseTools.last_insert_id;	
		
		String queryM2MBooksAuthors = "INSERT INTO `m2m_books_authors` (`b_id`, `a_id`) VALUES ('"+ b_id +"', '" + a_id + "')";
		String queryM2MBooksGenres = "INSERT INTO `m2m_books_genres` (`b_id`, `g_id`) VALUES ('"+ b_id +"', '" + g_id + "')";
		
		Integer affected_rows4 = this.dataBaseTools.changeDBData(queryM2MBooksAuthors);
		Integer affected_rows5 = this.dataBaseTools.changeDBData(queryM2MBooksGenres);
		
	
		// Если добавление прошло успешно...
		if (affected_rows1 > 0 && affected_rows2 > 0 && affected_rows3 > 0  && affected_rows4 > 0 && affected_rows5 > 0 )
		{
			System.out.println("Успешное добавление!");
		}
		else
		{
			System.out.println(false);
		}
//		ResultSet resultSetBooks = dataBaseTools.getDBData(queryInBooks);
//		ResultSet resultSetAuthors = dataBaseTools.getDBData(queryInAuthors);
//		ResultSet resultSetGenres = dataBaseTools.getDBData(queryInGenres);
//
//			try {
//				while(resultSet.next()){
//					System.out.println(resultSet.getString(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)
//					+" | "+resultSet.getString(4)+" | "+resultSet.getString(5)+" | "+resultSet.getString(6)	);
//					
//				}
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
	}

	@Override
	public void deleteBook(long idBook) throws DAOException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book book) throws DAOException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAllBooks() throws DAOException {
		String request = "SELECT b_id, b_name, a_name, g_name , b_year, b_quantity FROM library_ver2.books "
				+ "JOIN `m2m_books_authors` USING(`b_id`) "
				+ "JOIN `authors` USING(`a_id`) "
				+ "JOIN `m2m_books_genres` USING(`b_id`) "
				+ "JOIN `genres` USING(`g_id`);";

		ResultSet resultSet = dataBaseTools.getDBData(request);	

			try {
				while(resultSet.next()){
					System.out.println(resultSet.getString(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)
					+" | "+resultSet.getString(4)+" | "+resultSet.getString(5)+" | "+resultSet.getString(6)	);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
