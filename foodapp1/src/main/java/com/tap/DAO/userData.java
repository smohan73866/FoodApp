package com.tap.DAO;

import com.tap.models.Data;

public interface userData {
	
	public void addData(Data d);
	public String findData(Data d);
	public String findName(Data d);
	public boolean isNamePresent(Data d,String name);
	public Data getData(String name1);

}
