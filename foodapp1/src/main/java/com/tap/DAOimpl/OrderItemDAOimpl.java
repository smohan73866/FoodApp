package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.orderItemDAO;
import com.tap.models.OrderItem;
import com.util.DBConnection;

public class OrderItemDAOimpl implements orderItemDAO{

	@Override
	public void addOrderItem(OrderItem oi) {
		
		String Query1="INSERT into `orderitem` (orderitemid,orderid,menuid,quantity,totalamount) values(?,?,?,?,?)";
		
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt=con.prepareStatement(Query1);
			
			pstmt.setInt(1, oi.getOrderitemid());
			pstmt.setInt(2, oi.getOrderid());
			pstmt.setInt(3, oi.getMenuid());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setDouble(5, oi.getTotalamount());
			
			int i=pstmt.executeUpdate();
			System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderItem(int id) {
		
		
		
	}

	@Override
	public List<OrderItem> getOrderItem(int orderId) {
		
		List<OrderItem> list=new ArrayList<>();
		
		String Query2="SELECT * from orderitem where orderid=?";
		
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt=con.prepareStatement(Query2);
			
			pstmt.setInt(1, orderId);
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{
				
				int menuId=res.getInt("menuid");
				int quantity=res.getInt("quantity");
				
				OrderItem o=new OrderItem(menuId,quantity);
				list.add(o);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
		
		
		
	}

}
