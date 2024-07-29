package com.model;

public class LoginStudent {
	
	private String regnumber;
	private String username;
	private String password;
	public String getRegnumber() {
		return regnumber;
	}
	public void setRegnumber(String regnumber) {
		this.regnumber = regnumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginStudent [regnumber=" + regnumber + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
