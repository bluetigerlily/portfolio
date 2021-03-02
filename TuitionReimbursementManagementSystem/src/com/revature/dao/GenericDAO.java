package com.revature.dao;
import com.revature.beans.User;

public interface GenericDAO <T>{

	//create read update delete operations for generic object T
	public T add(T t) throws Exception;
	public T getbyUsername(String username) throws Exception;
	public User getAll() throws Exception;
	public void update(T t) throws Exception;
	public void delete(T t) throws Exception;
	
	
}
