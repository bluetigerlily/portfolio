package com.revature.dao.hibernate;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.beans.Events;
import com.revature.beans.User;
import com.revature.dao.EventsDAO;
import com.revature.utils.HibernateUtil;

public class EventsHibernate implements EventsDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Events add(Events t) throws Exception {

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
	public Events getbyUsername(String username) throws Exception {

		Session s = hu.getSession();
		Events e = s.get(Events.class, username);
		s.close();
		return e;
	}

	@Override
	public User getAll() throws Exception {
		Session s = hu.getSession();
		String query = "FROM events";
		Query<Events> q = s.createQuery(query, Events.class);
		java.util.List<Events> eventsList = q.getResultList();
		Set<Events> events = new HashSet<>();
		events.addAll(eventsList);
		s.close();
		return (User) events;
	}

	@Override
	public void update(Events t) throws Exception {
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
	public void delete(Events t) throws Exception {
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
	public Events getEventbyUserid(int userid) throws Exception {
		Session s = hu.getSession();
		Events e = s.get(Events.class, userid);
		s.close();
		return e;
	}

}
