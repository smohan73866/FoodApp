package com.tap.DAO;

import java.util.List;

import com.tap.models.Resturant;
import com.tap.models.User;

public interface resturantDAO {
	
	public void addResturant(Resturant r);
	 public Resturant getResturant(int resturantid);
	 public void updateResturant(Resturant r);
	 public void deleteUser(int resturantid);
	 public List<Resturant> getAllResturants();

}
