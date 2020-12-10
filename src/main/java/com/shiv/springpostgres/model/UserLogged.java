package com.shiv.springpostgres.model;

public class UserLogged {

	private String userName;
	private String token;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserLogged(String userName, String token) {
		super();
		this.userName = userName;
		this.token = token;
	}
	public UserLogged() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
