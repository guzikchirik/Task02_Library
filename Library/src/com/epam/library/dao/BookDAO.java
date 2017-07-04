package com.epam.library.dao;

import com.epam.library.bean.Book;
import com.epam.library.dao.exception.DAOException;

public interface BookDAO {
	void addBook(Book book) throws DAOException;
	void deleteBook(long idBook) throws DAOException;
	void delete(Book book) throws DAOException;
}
