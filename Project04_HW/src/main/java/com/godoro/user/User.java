package com.godoro.user;

public class User {
	private long userId;
	private String userName;
	private String userPassword;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User(long userId, String userName, String userPassword) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public User() {
	}

}
