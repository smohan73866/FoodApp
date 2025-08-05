package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			pstmt.setFloat(5, oi.getTotalamount());
			
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
	public OrderItem getOrderItem(int id) {
		return null;
	}

}
