/**
 * 
 */
package com.somesh.spring.security.model;

/**
 * @author ksomalin
 *
 */
public class AuthenticationRequest {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String password;

	public AuthenticationRequest() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
