package com.epam.library.bean;

public class User {
	private String login;
	private String password;
	private boolean signIn = false;
	private String access;
//	private enum status {N,U,A,SA};
//	private String name;
//	private String surname;
	
	public User(){}
	
	public User(String login, String password){		
		this.login = login;
		this.password = password;
	}
	
	public User(String login, String password, boolean signIn, String access){		
		this.login = login;
		this.password = password;
		this.signIn = signIn;
		this.access = access;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (signIn ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (signIn != other.signIn)
			return false;
		return true;
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
