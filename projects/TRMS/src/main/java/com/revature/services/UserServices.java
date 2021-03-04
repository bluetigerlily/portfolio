package com.revature.services;

import java.util.Set;

import com.revature.beans.Role;
import com.revature.beans.User;

public interface UserServices {

	public void updateUser(User user) throws Exception;

	public void deleteUser(User user) throws Exception;

	public User getUserbyUsername(String username) throws Exception;

	public User getRole() throws Exception;

	public User addRole() throws Exception;

	public User getUserbyId(int id) throws Exception;

	int CreateUser(User user) throws Exception;

	boolean validate(String username, String password);

	void saveUser(User user);

	public Set<Role> getAllRoles();

}
