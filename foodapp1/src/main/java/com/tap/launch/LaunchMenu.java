package com.tap.launch;

import java.util.Scanner;

import com.tap.DAOimpl.MenuDAOimpl;
import com.tap.models.Menu;

public class LaunchMenu {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
//		int menuid=sc.nextInt();
//		int resid=sc.nextInt();
//		sc.nextLine();
//		String itemname=sc.nextLine();
//		String description=sc.nextLine();
//		int price=sc.nextInt();
//		sc.nextLine();
//		String isavailable=sc.nextLine();
//		String rating=sc.nextLine();
//		String imagepath=sc.nextLine();
//		
//		Menu m=new Menu(menuid,resid,itemname,description,price,isavailable,rating,imagepath);
		
		MenuDAOimpl mdo=new MenuDAOimpl();
//		mdo.addMenu(m);
		
		Menu menu=mdo.getMenu(1);
		System.out.println(menu.equals(menu));
	}

}
