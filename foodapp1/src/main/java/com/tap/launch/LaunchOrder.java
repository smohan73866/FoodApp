package com.tap.launch;

import java.util.Scanner;

import com.tap.DAOimpl.OrderDAOimpl;
import com.tap.models.Order;

public class LaunchOrder {

	public static void main(String[] args) {
		
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Details:");
	int oid=sc.nextInt();
	int rid=sc.nextInt();
	int uid=sc.nextInt();
	
	int totalamount=sc.nextInt();
	sc.nextLine();
	String status=sc.nextLine();
	String paymentmode=sc.nextLine();
	
	Order o=new Order(oid,rid,uid,totalamount,status,paymentmode);
	
	OrderDAOimpl odi= new OrderDAOimpl();
	
	odi.addOrder(o);

	}

}
