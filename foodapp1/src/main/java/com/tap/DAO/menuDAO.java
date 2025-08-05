package com.tap.DAO;

import java.util.List;

import com.tap.models.Menu;

public interface menuDAO {
	
	public void addMenu(Menu m);
	public Menu getMenu(int menuId);
	public void updateMenu(Menu m);
	public void deleteMenu(int menuId);
	public List<Menu> getAllMenus(Menu m);
	public List<Menu> getByResturantId(int resturantId);

}
