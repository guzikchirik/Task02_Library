package com.epam.library.service.impl;

import com.epam.library.bean.Book;
import com.epam.library.dao.BookDAO;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.factory.DAOFactory;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addNewBook(Book book) {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			BookDAO bookDAO = daoObjectFactory.getBookDAO();
			bookDAO.addBook(book);
		} catch (DAOException e1) {
			System.out.println(e1.getMessage());
			
		}

	}

	@Override
	public void addEditBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showAllBooks() throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			BookDAO bookDAO = daoObjectFactory.getBookDAO();
			bookDAO.showAllBooks();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			throw new ServiceException("Something wrong:)");
		}
		
	}

}
