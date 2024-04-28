package models;

import conexion.User;

public class LoginDataModel {
	
	User loggedIn;

	
	
	public LoginDataModel(User loggedIn) {
		super();
		this.loggedIn = loggedIn;
	}
	
	public LoginDataModel() {
		this.loggedIn = null;
	}

	public User getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(User loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}

