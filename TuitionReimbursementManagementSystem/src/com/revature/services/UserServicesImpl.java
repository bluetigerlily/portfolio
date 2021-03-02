package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.dao.DAOFactory;
import com.revature.dao.RoleDAO;
import com.revature.dao.UserDAO;

public class UserServicesImpl implements UserServices{
		private UserDAO userdao;
		private RoleDAO roledao;
	
   public static Logger Log = Logger.getLogger(UserServicesImpl.class);
   
   public UserServicesImpl() {
	   userdao = DAOFactory.getUserDAO();
	   roledao = DAOFactory.getRoleDAO();
   }
   
	@Override
	public void deleteUser(User user) throws Exception {
				if (getUserbyUsername(user.getUsername()) != null)
					userdao.delete(user);
				else
					Log.debug("Person didn't exist in the database.");
	}

	
	@Override
	public int CreateUser(User user) throws Exception {
		return userdao.add(user).getUserid();
	}

	

	public User getUserbyUsername(String username) throws Exception{
		return userdao.getbyUsername(username);
	}

	@Override
	public void updateUser(User user) throws Exception {
		if (getUserbyUsername(user.getUsername()) != null)
			userdao.update(user);
		else
			Log.debug("Person didn't exist in the database.");
	}

	public User getRole() throws Exception{
		return ((UserServicesImpl) roledao).getRole();
	}


	@Override
	public User addRole() throws Exception {
		return ((UserServicesImpl) roledao).addRole();
	}

	public User getUserbyUserid(int userid) throws Exception {
		return userdao.getbyUserid(userid);
	}

	


	
	
	
//try (Connection con = conn.getConnection()) {	
//		
//		String sql ="INSERT INTO user (userid, username, password) VALUES(default, ?, ?)";
//		String[] keys = {"cusid"};
//		PreparedStatement pmpt = con.prepareStatement(sql, keys);
//						con.setAutoCommit(false);	
//				pmpt.setString(1, user.getUsername());
//				pmpt.setString(2, user.getPassword());
//				pmpt.executeUpdate();
//				ResultSet rs = pmpt.getGeneratedKeys();
//						
//						while (rs.next()) {
//							 User userzard = new User();
//							User u = userzard;
//							u.setUserid(rs.getInt(1));
//							con.commit(); 
//							if(u.equals(null)) {
//								con.rollback(); } } 
//					} catch (Exception e ) {
//						if (e.getMessage().contains("violates unique username constraint")) {
//							
//		}
//		
//		
//		
//	} 
//		return user;
//	}

}
