package com.tap.launch;

import java.util.Scanner;

import com.tap.DAOimpl.UserDAOimpl;
import com.tap.models.User;

public class LaunchUser {
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the name: ");
		String name=sc.nextLine();
		
		System.out.println("Enter the username");
		String username=sc.nextLine();
		
		System.out.println("Enter the password: ");
		String password=sc.nextLine();
		
		System.out.println("Enter the email");
		String email=sc.nextLine();
		
		System.out.println("Enter the phonenumber: ");
		String phonenumber=sc.nextLine();
		
		System.out.println("Enter the address");
		String address=sc.nextLine();
		
		System.out.println("Enter the role: ");
		String role=sc.nextLine();
		
		User u=new User(name,username,password,email,phonenumber,address,role);
		
		 UserDAOimpl udo=new UserDAOimpl();
		 udo.addUser(u);
		
		
		
	}

}
