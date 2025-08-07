package com.tap.DAO;

import java.util.List;

import com.tap.models.User;

public interface userDAO {
	
	 public User getUser(int userId);
	 public void updateUser(User u);
	 public void deleteUser(int userId);
	 public List<User> getAllUsers();

}
