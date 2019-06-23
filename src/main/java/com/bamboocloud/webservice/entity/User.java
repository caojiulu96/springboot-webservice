package com.bamboocloud.webservice.entity;

import java.io.Serializable;

/**
 * 
 * @author jiulus
 *
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7726619262398869203L;

	private String userid; //id
	
	private String username; //用户号
	
	private String fullname; //用户姓名

	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
