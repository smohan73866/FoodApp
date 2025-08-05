package com.tap.models;

public class Menu {
	
	private int menuid;
	private int resturantid;
	private String itemname;
	private String description;
	private int price;
	private String isavailable;
	private String rating;
	private String imagepath;
	public Menu() {
		super();
	}
	public Menu(int menuid, int resturantid, String itemname, String description, int price, String isavailable,
			String rating, String imagepath) {
		super();
		this.menuid = menuid;
		this.resturantid = resturantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
		this.rating = rating;
		this.imagepath = imagepath;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getResturantid() {
		return resturantid;
	}
	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIsavailable() {
		return isavailable;
	}
	public void setIsavailable(String isavailable) {
		this.isavailable = isavailable;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", resturantid=" + resturantid + ", itemname=" + itemname + ", description="
				+ description + ", price=" + price + ", isavailable=" + isavailable + ", rating=" + rating
				+ ", imagepath=" + imagepath + "]";
	}
	
	
}
