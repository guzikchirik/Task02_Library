package com.epam.library.bean;

public class User {
	private String login;
	private String password;
	private boolean signIn = false;
//	private String name;
//	private String surname;
	
	public User(){}
	
	public User(String login, String password){		
		this.login = login;
		this.password = password;
	}
	
	public void setLogin(String login){
		this.login = login;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setSignIn(boolean signIn){
		this.signIn = signIn;
	}
//	public void setName(String name){
//		this.name = name;
//	}
//	public void setSurname(String surname){
//		this.surname = surname;
//	}
	
	public String getLogin(){
		return login;
	}	
	public String getPassword(){
		return password;
	}
	public boolean getSignIn(){
		return signIn;
	}
//	public String getName(){
//		return name;
//	}	
//	public String getSurname(){
//		return surname;
//	}
}
