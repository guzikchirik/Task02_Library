package com.epam.library.bean;

public class Book {
	private String title;	
	private String author;
	private String genre;
	private int year;
	private int quantity;
	
	public Book(){}
	
	public Book(String title){
		this.title = title;		
	}
	
	public Book(String title,String author, String genre, int year, int quantity){
		this.title = title;	
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.quantity = quantity;
	}
	
	public void setTitle(String title){
		this.title = title;
	}	
	
	public String getTitle(){
		return title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}		
}
