package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.tap.DAO.userData;
import com.tap.models.Data;
import com.util.DBConnection1;

public class UserDataimpl implements userData {
	
	static String Query1="insert into `data`(name,password,phonenumber,email,image) value(?,?,?,?,?)";
	static String Query2="select `password` from `data` where name=?";
	static String Query3="select `name` from `data` where name=?";
	
	public void addData(Data d) 
	{
		
		try(Connection con=DBConnection1.getConnection();
		
		PreparedStatement pstmt= con.prepareStatement(Query1);) {
			
			
			pstmt.setString(1,d.getName());
			pstmt.setString(2,d.getPassword());
			pstmt.setString(3,d.getPhonenumber());
			pstmt.setString(4,d.getEmail());
			pstmt.setString(5,d.getImage());
			
			
			int i=pstmt.executeUpdate();
			System.out.println(i);
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public String findData(Data d)
	{
		try(Connection con=DBConnection1.getConnection();
				
				PreparedStatement pstmt= con.prepareStatement(Query2);) {
					
					
					pstmt.setString(1,d.getName());
					
					
					ResultSet res=pstmt.executeQuery();
					
					while(res.next()==true)
					{
						String password=res.getString("password");
						return password;
						
					}
					
					
					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
	
	return null;
	
	}
	
	public String findName(Data d)
	{
try(Connection con=DBConnection1.getConnection();
				
				PreparedStatement pstmt= con.prepareStatement(Query3);) {
					
					
					pstmt.setString(1,d.getName());
					
					
					ResultSet res=pstmt.executeQuery();
					
					while(res.next()==true)
					{
						String name=res.getString("name");
						return name;
						
					}
					
					
					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
	
	return null;
	
	}

	
	public boolean isNamePresent(Data d,String name) {
		
    try(Connection con=DBConnection1.getConnection();
				
	PreparedStatement pstmt= con.prepareStatement(Query3);) {
					
					
					pstmt.setString(1,d.getName());
					
					
					ResultSet res=pstmt.executeQuery();
					
					while(res.next()==true)
					{
						String name1=res.getString("name");
						if(name1.equals(name))
						{
							return true;
						}
						
					}
					
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return false;
	


	}

	@Override
	public Data getData(String name1) {
		
		String Query="select * from `data` where name=?";
		Data d=null;
		
		Connection con=DBConnection1.getConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(Query);
			pstmt.setString(1, name1);
			
			ResultSet res=pstmt.executeQuery();
			
			
			while(res.next())
			{
				String phone=res.getString("phonenumber");
				String image=res.getString("image");
				String email=res.getString("email");
				
				d=new Data(name1,phone,email,image);
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}
	}
