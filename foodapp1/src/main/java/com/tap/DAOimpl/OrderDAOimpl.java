package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.orderDAO;
import com.tap.models.Order;
import com.tap.models.Resturant;
import com.util.DBConnection;

public class OrderDAOimpl implements orderDAO {
	
	String Query1="insert into orders (orderid,resturantid,userid,orderdate,totalamount,status,paymentmode) values(?,?,?,?,?,?,?)";
	String Query2="Select * from orders where userid=?";
	@Override
	public int addOrder(Order o) {
		
		
		Connection con=DBConnection.getConnection();
		
		int orderId=0;
		PreparedStatement pstmt;
			try {
//				pstmt = con.prepareStatement(Query1);
				
				pstmt = con.prepareStatement(Query1,Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, o.getOrderid());
				pstmt.setInt(2, o.getResturantid());
				pstmt.setInt(3, o.getUserid());
				pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				pstmt.setDouble(5, o.getTotalamount());
				pstmt.setString(6, o.getStatus());
				pstmt.setString(7, o.getPaymentmode());
				
				int i=pstmt.executeUpdate();
				System.out.println(i);
				
				ResultSet res=pstmt.getGeneratedKeys();
				
				while(res.next())
				{
					orderId=res.getInt(1);
				}
				
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return orderId;
			
			
		
		
		
	}
	
	public List<Order> getOrder(int userId)
	{
		
		List<Order> list=new ArrayList<>();
		Connection con=DBConnection.getConnection();
		
		try {
			
			PreparedStatement pstmt=con.prepareStatement(Query2);
			pstmt.setInt(1, userId);
			
			
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{	
				int orderId=res.getInt("orderid");
				int resturantId=res.getInt("resturantid");
				
				ResturantDAOimpl rdo=new ResturantDAOimpl();
				Resturant r=rdo.getResturant(resturantId);
				String resturantName=r.getName();
				
				Timestamp orderDate=res.getTimestamp("orderdate");
				Double totalAmount=res.getDouble("totalamount");
				String status=res.getString("status");
				
				Order o=new Order(orderId,resturantId,resturantName,orderDate,totalAmount,status);
				
				list.add(o);
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
}

	
	


