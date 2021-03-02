package com.revature.services;
import com.revature.beans.*;



public interface UserServices {

	

	public void updateUser(User user) throws Exception;
	public void deleteUser(User user) throws Exception;
	public User getUserbyUsername(String username) throws Exception;
	public User getRole() throws Exception;
	public User addRole() throws Exception;
	public User getUserbyUserid(int userid) throws Exception;
	int CreateUser(User user) throws Exception;
	

}
	

	


