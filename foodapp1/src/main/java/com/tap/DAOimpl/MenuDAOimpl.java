package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.menuDAO;
import com.tap.models.Menu;
import com.util.DBConnection;

public class MenuDAOimpl implements menuDAO {
	
	String add="insert into menu (menuid,resturantid,itemname,description,price,isavailable,rating,imagepath) values(?,?,?,?,?,?,?,?)";

	@Override
	public void addMenu(Menu m) {
		
		
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(add);	) {
			
		
		
		pstmt.setInt(1, m.getMenuid());
		pstmt.setInt(2, m.getResturantid());
		pstmt.setString(3, m.getItemname());
		pstmt.setString(4, m.getDescription());
		pstmt.setInt(5, m.getPrice());
		pstmt.setString(6, m.getIsavailable());
		pstmt.setString(7, m.getRating());
		pstmt.setString(8, m.getImagepath());
		
		
		int i=pstmt.executeUpdate();
		
		System.out.println(i);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Menu getMenu(int menuId) {
		
		String get_Query="select * from menu where menuid=?";
		
		
		Menu m=null;
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(get_Query);	) {
			
			pstmt.setInt(1, menuId);
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{
				int menuid=res.getInt("menuid");
				int resturantid=res.getInt("resturantid");
				String itemname=res.getString("itemname");
				String description=res.getString("description");
				int price=res.getInt("price");
				String isavailable=res.getString("isavailable");
				String rating=res.getString("rating");
				String imagepath=res.getString("imagepath");
				
				m=new Menu(menuid,resturantid,itemname,description,price,isavailable,rating,imagepath);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public void updateMenu(Menu m) {
		
		String update="UPDATE menu SET `description`=? `price`=? `rating`=?";
		
		
		
		
	}

	@Override
	public void deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Menu> getAllMenus(Menu m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getByResturantId(int resturantId) {
		
		String Query="select * from menu where resturantid=?";
		List<Menu> list=new ArrayList<Menu>();
			Menu m;
			Connection con=DBConnection.getConnection();
			try {
				PreparedStatement pstmt=con.prepareStatement(Query);
				pstmt.setInt(1, resturantId);
				
				ResultSet res=pstmt.executeQuery();
				
				while(res.next())
				{
					int menuid=res.getInt("menuid");
					int resturantid=res.getInt("resturantid");
					String itemname=res.getString("itemname");
					String description=res.getString("description");
					int price=res.getInt("price");
					String isavailable=res.getString("isavailable");
					String rating=res.getString("rating");
					String imagepath=res.getString("imagepath");
					
					m=new Menu(menuid,resturantid,itemname,description,price,isavailable,rating,imagepath);
					list.add(m);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	
	

}
