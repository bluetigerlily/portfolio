package com.revature.data.hibernate;

import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import com.revature.beans.Status;
import com.revature.data.StatusDAO;
import com.revature.utils.HibernateUtil;

public class StatusHibernate implements StatusDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	
	@Override
	public Status getById(Integer id) {
		Session s = hu.getSession();
		// Criteria API: make queries w/ programmatic syntax
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Status> criteria = cb.createQuery(Status.class);
		Status sat = s.createQuery(criteria).getSingleResult();
		return sat;
	

	}
	@Override
	public Set<Status> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Status t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Status t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Status add(Status s) {
		// TODO Auto-generated method stub
		return null;
	}

}
