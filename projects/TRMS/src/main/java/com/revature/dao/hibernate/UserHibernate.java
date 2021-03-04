package com.revature.dao.hibernate;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Events;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.utils.HibernateUtil;

public class UserHibernate implements UserDAO {
	public final String updateEvents = null;
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	
	public Events updateEvents(Events e) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx =s.beginTransaction();
			s.update(e);
			tx.commit();
		
		} catch (Exception e1) {
			if 	(tx != null) 
			tx.rollback();
	} finally {
		s.close();
		}
		return e;
	}

	@Override
	public User add(User t) throws Exception {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(t);
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}

		return t;
	}

	@Override
	public User getbyUsername(String username) throws Exception {
		Session s = hu.getSession();
		User u = s.get(User.class, username);
		s.close();
		return u;
	}

	@Override
	public User getAll() throws Exception {
		Session s = hu.getSession();
		String query = "FROM user";
		Query<User> q = s.createQuery(query, User.class);
		java.util.List<User> userList = q.getResultList();
		Set<User> user = new HashSet<>();
		user.addAll(userList);
		s.close();
		return (User) user;
	}

	@Override
	public void update(User t) throws Exception {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
	}

	@Override
	public void delete(User t) throws Exception {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}

	}

	@Override
	public User getbyId(int id) throws Exception {
		Session s = hu.getSession();
		User u = s.get(User.class, id);
		s.close();
		return u;
	}

	@Override
	public void save(User t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User setUserbyId(int id) throws Exception {
		
		return null;
	}

}
