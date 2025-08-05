package com.tap.models;

public class Resturant {
	private int resturantid;
	private String name;
	private String address;
	private String phonenumber;
	private String cuisinetype;
	private int deliverytime;
	private int adminuserid;
	private String rating;
	private String isactive;
	private String imagepath;
	public Resturant() {
		super();
	}
	public Resturant(int resturantid, String name, String address, String phonenumber, String cuisinetype,
			int deliverytime, int adminuserid, String rating, String isactive, String imagepath) {
		super();
		this.resturantid = resturantid;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.adminuserid = adminuserid;
		this.rating = rating;
		this.isactive = isactive;
		this.imagepath = imagepath;
	}
	public int getResturantid() {
		return resturantid;
	}
	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCuisinetype() {
		return cuisinetype;
	}
	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}
	public int getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}
	public int getAdminuserid() {
		return adminuserid;
	}
	public void setAdminuserid(int adminuserid) {
		this.adminuserid = adminuserid;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return "Resturant [resturantid=" + resturantid + ", name=" + name + ", address=" + address + ", phonenumber="
				+ phonenumber + ", cuisinetype=" + cuisinetype + ", deliverytime=" + deliverytime + ", adminuserid="
				+ adminuserid + ", rating=" + rating + ", isactive=" + isactive + ", imagepath=" + imagepath + "]";
	}
	
	
	
	

}
