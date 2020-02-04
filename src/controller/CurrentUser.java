package controller;

import model.DTO.User;

public class CurrentUser {
	private  User user = new User();
	public  User getUser() {
		return user;
	}
	public  void setUser(User user) {
		this.user = user;
	}
}
