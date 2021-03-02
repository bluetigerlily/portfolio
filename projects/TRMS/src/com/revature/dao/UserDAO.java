package com.revature.dao;

import com.revature.beans.User;

public interface UserDAO extends GenericDAO<User> {
	@Override
	public User getbyUsername(String username) throws Exception;

	User getbyUserid(int userid) throws Exception;

}
