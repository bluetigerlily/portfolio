package com.revature.dao.hibernate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.utils.HibernateUtil;

public class UserHibernate implements UserDAO{
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public User add(User t) throws Exception {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
		} finally {
			s.close();
		}
		
		
		return t;
	}

	@Override
	public User getbyUsername(String username) throws Exception {
		Session s = hu.getSession();
	     User u =s.get(User.class, username);
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
		user.addAll((Collection<? extends User>) userList);
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
			if (tx != null) tx.rollback(); 
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
		} catch (Exception e )
		{ if (tx != null ) tx.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public User getbyUserid(int userid) throws Exception {
		Session s = hu.getSession();
	     User u =s.get(User.class, userid);
		s.close();
		return u;
	}

	
	
	
	
	
	
	
	
}
