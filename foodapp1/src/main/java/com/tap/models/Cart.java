package com.tap.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<Integer,CartItem> items;
	private int totalPrice;

	public Cart() {
		this.items=new HashMap<>();
		}
	
	public void addItem(CartItem item)
	{
		int itemId=item.getItemId();
		if(items.containsKey(itemId))
		{
			CartItem existingItem=items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
		}
		else {
			items.put(itemId, item);
		}
		
		
	}
	
	public void updateItem(int itemId,int quantity)
	{
		if(items.containsKey(itemId))
		{
			if(quantity <= 0)
			{
				items.remove(itemId);
			}
			else {
				CartItem existingCartItem = items.get(itemId);
				existingCartItem.setQuantity(quantity);
				
			}
		}
	}
	
	public void deleteItem(int itemId)
	{
		items.remove(itemId);
	}
	
	public Map<Integer,CartItem> getItems(){
		return items;
		
	}
	
	public void clear()
	{
		items.clear();
	}
	public int getTotalPrice()
	{
		totalPrice=0;
		for(CartItem ci:items.values())
		{
			totalPrice=(int) (totalPrice+ci.getPrice()*ci.getQuantity());
		}
		return totalPrice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
