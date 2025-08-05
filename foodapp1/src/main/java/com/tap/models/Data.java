package com.tap.models;

public class Data {
	private String name;
	private String password;
	private String phonenumber;
	private String email;
	private String image;
	public Data(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
	
	public Data() {
		super();
	}



	public Data(String name, String phonenumber, String email, String image) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.image = image;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Data(String name, String password, String phonenumber, String email, String image) {
		super();
		this.name = name;
		this.password = password;
		this.phonenumber = phonenumber;
		this.email = email;
		this.image = image;
	}



	public Data(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String toString()
	{
		return name+" "+password;
	}
}
