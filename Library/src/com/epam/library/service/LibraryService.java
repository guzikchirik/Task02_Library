package com.epam.library.service;

import com.epam.library.bean.Book;
import com.epam.library.service.exception.ServiceException;

public interface LibraryService {
	void addNewBook(Book book) throws ServiceException;
	void addEditBook(Book book) throws ServiceException;
	void showAllBooks()throws ServiceException;
}
