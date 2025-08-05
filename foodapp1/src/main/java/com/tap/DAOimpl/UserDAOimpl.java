package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.userDAO;
import com.tap.models.User;
import com.util.DBConnection;

public class UserDAOimpl implements userDAO {
	
	String Query1="insert into `user`(name,username,password,email,phonenumber,address,role,createdate,lastlogindate) values(?,?,?,?,?,?,?,?,?)";
	
	@Override
	public void addUser(User u) {
		
		
		
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(Query1);)
		{
			
			
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getPhonenumber());
			pstmt.setString(6, u.getAddress());
			pstmt.setString(7,u.getRole());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			
			
			int i=pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public User getUser(int userId) {
		String Query2="SELECT * FROM `user` WHERE `userid` = ?";
		
		User u=null;
		
		
		try(Connection connection=DBConnection.getConnection();
			PreparedStatement pstmt=connection.prepareStatement(Query2);) {
			
			
			pstmt.setInt(1, userId);
			
			ResultSet res = pstmt.executeQuery();
			
			String name=res.getString("name");
			String username=res.getString("username");
			String password=res.getString("password");
			String email=res.getString("email");
			String phone=res.getString("phonenumber");
			String address=res.getString("address");
			String role=res.getString("role");
			
			u=new User(userId,name,username,password,email,phone,address,role,null,null);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void updateUser(User u) {
		
		String Query3="UPDATE `user` SET `name`=? `password`=? `phone`=? `address`=? `role`=?";
		
		
		try (Connection connection=DBConnection.getConnection();
			PreparedStatement pstmt= connection.prepareStatement(Query3);){
			
			pstmt.setString(1,u.getName());
			pstmt.setString(2,u.getPassword());
			pstmt.setString(3,u.getPhonenumber());
			pstmt.setString(4,u.getAddress());
			pstmt.setString(5,u.getRole());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		
		String Query4="DELETE FROM `user` WHERE `userid`=?";
		
		
		try(Connection connection=DBConnection.getConnection();
			PreparedStatement pstmt=connection.prepareStatement(Query4);) {
			
			pstmt.setInt(1, userId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		
		String Query5="SELECT * From `user`";
		
		ArrayList<User> usersList=new ArrayList<User>();
		
		
		try(Connection connection=DBConnection.getConnection();
			Statement statement=connection.createStatement();) {
			
			ResultSet res=statement.executeQuery(Query5);
			
			while(res.next())
			{	
				int userid=res.getInt("userid");
				String name=res.getString("name");
				String username=res.getString("username");
				String password=res.getString("password");
				String email=res.getString("email");
				String phone=res.getString("phonenumber");
				String address=res.getString("address");
				String role=res.getString("role");
			
			
			User u=new User(userid,name,username,password,email,phone,address,role,null,null);
			usersList.add(u);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	

}
