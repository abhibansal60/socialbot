package org.abhinav.automation.model;

public class User {
	String username;
	String password;
	String usernames;
	
	
	

	public User() {
		super();
	}
	
	
	
	public User(String username, String password, String usernames) {
		super();
		this.username = username;
		this.password = password;
		this.usernames = usernames;
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
	public String getUsernames() {
		return usernames;
	}

	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}
	
	
}
