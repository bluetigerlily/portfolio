package com.revature.services;

import java.util.Set;

import com.revature.beans.Events;
import com.revature.beans.Role;
import com.revature.beans.User;
import com.revature.exceptions.NonUniqueUsernameException;

public interface UserServices {

	public void updateUser(User user) throws Exception;

	public void deleteUser(User user) throws Exception;

	public User getUserbyUsername(String username) throws Exception;

	public User getRole() throws Exception;

	public User addRole() throws Exception;

	public User getUserbyId(int id) throws Exception;

	int CreateUser(User user) throws Exception;

	boolean validate(String username, String password) throws Exception;

	void saveUser(User user) throws Exception;

	public Set<Role> getAllRoles() throws Exception;
	
	public Integer addUser(User user) throws NonUniqueUsernameException;
	
	public int addEvent(Events e) throws Exception;

	void approveEvents(User u, Events e) throws Exception;

	Events updateEvents(Events e) throws Exception;

	Object getRolebyId() throws Exception;

	Object getUserbyId() throws Exception;
	
	

}
