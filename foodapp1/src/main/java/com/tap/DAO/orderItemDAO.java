package com.tap.DAO;

import java.util.List;

import com.tap.models.OrderItem;

public interface orderItemDAO {
	
	abstract void addOrderItem(OrderItem oi);
	abstract void deleteOrderItem(int id);
	abstract List<OrderItem> getOrderItem(int id);
	

}
