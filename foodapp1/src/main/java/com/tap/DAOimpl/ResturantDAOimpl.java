package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.resturantDAO;
import com.tap.models.Resturant;
import com.util.DBConnection;

public class ResturantDAOimpl implements resturantDAO{
	
	String add="insert into resturant (resturantid,name,address,phonenumber,cuisinetype,deliverytime,adminuserid,rating,isactive,imagepath) values(?,?,?,?,?,?,?,?,?,?)";
	@Override
	public void addResturant(Resturant r) {
		
    Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt=con.prepareStatement(add);
			
			pstmt.setInt(1, r.getResturantid());
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getAddress());
			pstmt.setString(4, r.getPhonenumber());
			pstmt.setString(5, r.getCuisinetype());
			pstmt.setInt(6, r.getDeliverytime());
			pstmt.setInt(7,r.getAdminuserid());
			pstmt.setString(8, r.getRating());
			pstmt.setString(9,r.getIsactive());
			pstmt.setString(10, r.getImagepath());
			
			
			int i=pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public Resturant getResturant(int resturantid) {
		String get_resturant="SELECT * from `resturant` where `resturantid`=?";
		
		Resturant r=null;
		try (Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(get_resturant);){
			
			
			pstmt.setInt(1, resturantid);
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{
				int id=resturantid;
				String name=res.getString("name");
				String address=res.getString("address");
				String phone=res.getString("phonenumber");
				String cusinetype=res.getString("cuisinetype");
				int deliverytime=Integer.parseInt(res.getString("deliverytime"));
				int adminuserid=Integer.parseInt(res.getString("adminuserid"));
				String rating=res.getString("rating");
				String isactive=res.getString("isactive");
				String imagepath=res.getString("imagepath");
				
				r=new Resturant(id,name,address,phone,cusinetype,deliverytime,adminuserid,rating,isactive,imagepath);
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
	@Override
	public void updateResturant(Resturant r) {
		
		String update="UPDATE  `resturant` SET name=? address=? phonenumber=?";
		
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(update);	) {
			
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getAddress());
			pstmt.setString(3, r.getPhonenumber());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteUser(int resturantid) {
		
		String del="DELETE  from resturant where id=?";
		
		
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(del);) {
			
			pstmt.setInt(1, resturantid);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Resturant> getAllResturants() {
		
		List<Resturant> list=new ArrayList<>();
		
		String Query="SELECT * from resturant";
		
		
		Resturant r=null;
		
		try(Connection con=DBConnection.getConnection();
			Statement stmt=con.createStatement();) {
			
			ResultSet res=stmt.executeQuery(Query);
			
			while(res.next())
			{
				int id=res.getInt("resturantid");
				String name=res.getString("name");
				String address=res.getString("address");
				String phone=res.getString("phonenumber");
				String cusinetype=res.getString("cuisinetype");
				int deliverytime=Integer.parseInt(res.getString("deliverytime"));
				int adminuserid=Integer.parseInt(res.getString("adminuserid"));
				String rating=res.getString("rating");
				String isactive=res.getString("isactive");
				String imagepath=res.getString("imagepath");
				
				r=new Resturant(id,name,address,phone,cusinetype,deliverytime,adminuserid,rating,isactive,imagepath);
				list.add(r);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	


		
	}
	


