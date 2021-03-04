package com.revature.services;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.beans.Role;
import com.revature.beans.User;
import com.revature.dao.DAOFactory;
import com.revature.dao.RoleDAO;
import com.revature.dao.UserDAO;
import com.revature.utils.HibernateUtil;

public class UserServicesImpl implements UserServices {
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
		return userdao.add(user).getId();
	}

	@Override
	public User getUserbyUsername(String username) throws Exception {
		return userdao.getbyUsername(username);
	}

	@Override
	public void updateUser(User user) throws Exception {
		if (getUserbyUsername(user.getUsername()) != null)
			userdao.update(user);
		else
			Log.debug("Person didn't exist in the database.");
	}

	@Override
	public User getRole() throws Exception {
		return ((UserServicesImpl) roledao).getRole();
	}

	@Override
	public User addRole() throws Exception {
		return ((UserServicesImpl) roledao).addRole();
	}

	@Override
	public User getUserbyId(int id) throws Exception {
		return userdao.getbyId(id);
	}
	
	@Override 
	public boolean validate(String username, String password) {
		org.hibernate.Transaction transaction = null;
		User user = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			user = (User) session.createQuery("FROM user u where u.username = :username").setParameter("username",username).uniqueResult();

			if(user != null && user.getPassword().equals(password)) {
				return true;
			}
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void saveUser(User user) {
		org.hibernate.Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Set<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
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
