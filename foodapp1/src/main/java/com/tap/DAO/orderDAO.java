package com.tap.DAO;

import java.util.List;

import com.tap.models.Order;

public interface orderDAO {
	
	public int addOrder(Order o);
	public List<Order> getOrder(int userId);

}
