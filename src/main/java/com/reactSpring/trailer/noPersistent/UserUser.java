package com.reactSpring.trailer.noPersistent;

public class UserUser {
	private String login;
	private String password;
	
	public UserUser() {
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserUser [login=" + login + ", password=" + password + "]";
	}
	
}
