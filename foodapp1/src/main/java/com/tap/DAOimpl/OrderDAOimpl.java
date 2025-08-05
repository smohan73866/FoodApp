package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.tap.DAO.orderDAO;
import com.tap.models.Order;
import com.util.DBConnection;

public class OrderDAOimpl implements orderDAO {
	
	String Query1="insert into orders (orderid,resturantid,userid,orderdate,totalamount,status,paymentmode) values(?,?,?,?,?,?,?)";

	@Override
	public void addOrder(Order o) {
		
	
		
		Connection con=DBConnection.getConnection();
		
		
		PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(Query1);
				pstmt.setInt(1, o.getOrderid());
				pstmt.setInt(2, o.getResturantid());
				pstmt.setInt(3, o.getUserid());
				pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				pstmt.setInt(5, o.getTotalamount());
				pstmt.setString(6, o.getStatus());
				pstmt.setString(7, o.getPaymentmode());
				
				int i=pstmt.executeUpdate();
				System.out.println(i);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		
		
		
	}
}

	
	


