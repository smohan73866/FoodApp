package com.tap.launch;

import java.util.Scanner;

import com.tap.DAOimpl.ResturantDAOimpl;
import com.tap.models.Resturant;

public class LaunchResturant {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int rid=sc.nextInt();
		sc.nextLine();
		String name=sc.nextLine();
		String address=sc.nextLine();
		String pn=sc.nextLine();
		String cuitype=sc.nextLine();
		int delivery=sc.nextInt();
		int adminuserid=sc.nextInt();
		sc.nextLine();
		String rating=sc.nextLine();
		String isactive=sc.nextLine();
		String path=sc.nextLine();
		
		
		Resturant r=new Resturant(rid,name,address,pn,cuitype,delivery,adminuserid,rating,isactive,path);
		
		ResturantDAOimpl rdo=new ResturantDAOimpl();
		rdo.addResturant(r);
	}

}
