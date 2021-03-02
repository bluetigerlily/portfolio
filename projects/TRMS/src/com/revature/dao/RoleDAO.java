package com.revature.dao;

import com.revature.beans.Role;

public interface RoleDAO extends GenericDAO<Role> {
	@Override
	public Role add(Role r) throws Exception;

	Role getbyUserid(String userid) throws Exception;
}
