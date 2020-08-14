package com.pranish.model;

import java.io.Serializable;
//Model Class of Admin(Banker)
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ausername;
	private String apassword;

	public String getAdminname() {
		return ausername;
	}

	public void setAdminname(String ausername) {
		this.ausername = ausername;
	}

	public String getAPassword() {
		return apassword;
	}

	public void setAPassword(String apassword) {
		this.apassword = apassword;
	}
}