package com.inn.navin.jwt.user.jwt;

import com.inn.navin.jwt.user.model.User;

public class JwtResponse {
	private User user;
	private String token;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public JwtResponse(User user, String token) {
		this.user = user;
		this.token = token;
	}	
}
