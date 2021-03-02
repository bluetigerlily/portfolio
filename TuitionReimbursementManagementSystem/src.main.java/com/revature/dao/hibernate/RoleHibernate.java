package com.revature.dao.hibernate;

import java.util.HashSet;
import java.util.Set;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.revature.beans.Role;
import com.revature.beans.User;
import com.revature.dao.RoleDAO;
import com.revature.utils.HibernateUtil;

public class RoleHibernate implements RoleDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Role add(Role t) throws Exception {
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
	public Role getbyUserid(String userid) throws Exception {
		Session s = hu.getSession();
		Role r = s.get(Role.class, userid);
		s.close();
		return r;
	}

	@Override
	public User getAll() throws Exception {
		Session s = hu.getSession();
		String query = "FROM role";
		Query<Role> q = s.createQuery(query, Role.class);
		java.util.List<Role> roleList = q.getResultList();
		Set<Role> role = new HashSet<>();
		role.addAll(roleList);
		s.close();
		return (User) role;
	}

	@Override
	public void update(Role t) throws Exception {
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
	public void delete(Role t) throws Exception {
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
	public Role getbyUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//
//	@Override
//	public Role getbyUsername(String username) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
