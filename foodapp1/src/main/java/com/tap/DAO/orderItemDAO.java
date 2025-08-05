package com.tap.DAO;

import com.tap.models.OrderItem;

public interface orderItemDAO {
	
	abstract void addOrderItem(OrderItem oi);
	abstract void deleteOrderItem(int id);
	abstract OrderItem getOrderItem(int id);
	

}
