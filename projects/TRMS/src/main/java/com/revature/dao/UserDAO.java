package com.revature.dao;

import com.revature.beans.User;

public interface UserDAO extends GenericDAO<User> {
	@Override
	public User getbyUsername(String username) throws Exception;

	User getbyId(int id) throws Exception;
	
	public User setUserbyId(int id) throws Exception;
	

	
	
}
