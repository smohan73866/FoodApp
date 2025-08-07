package com.tap.models;

import java.sql.Timestamp;

public class Order {
	
	private int orderid;
	private int resturantid;
	private String resturantName;
	private int userid;
	private Timestamp orderdate;
	private Double totalamount;
	private String status;
	private String paymentmode;
	public Order() {
		super();
	}
	
	
	public Order(int orderid, int resturantid,String resturantName,Timestamp orderdate, Double totalamount, String status) {
		super();
		this.orderid = orderid;
		this.resturantid = resturantid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.status = status;
		this.resturantName=resturantName;
	}


	public String getResturantName() {
		return resturantName;
	}


	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}


	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}


	public Order(int orderid, int resturantid, int userid, double totalamount, String status, String paymentmode) {
		super();
		this.orderid = orderid;
		this.resturantid = resturantid;
		this.userid = userid;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	
	
	
	public Order(int resturantid, int userid, double totalamount, String status, String paymentmode) {
		super();
		this.resturantid = resturantid;
		this.userid = userid;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	public Order(int orderid, int resturantid, int userid, Timestamp orderdate, double totalamount, String status,
			String paymentmode) {
		super();
		this.orderid = orderid;
		this.resturantid = resturantid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getResturantid() {
		return resturantid;
	}
	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	@Override
	public String toString() {
		return "order [orderid=" + orderid + ", resturantid=" + resturantid + ", userid=" + userid + ", orderdate="
				+ orderdate + ", totalamount=" + totalamount + ", status=" + status + ", paymentmode=" + paymentmode
				+ "]";
	}
	
	

}
