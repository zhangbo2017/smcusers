package com.ibm.users.model;


/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:55:34 PM
*/
public class AuthRequest {

	// private String email;
	
	// public String getEmail() {
	// 	return email;
	// }
	// public void setEmail(String email) {
	// 	this.email = email;
	// }

	private String username;

	private String password;
	
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

}
