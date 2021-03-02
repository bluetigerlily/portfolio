package com.revature.dao;

import com.revature.dao.hibernate.EventsHibernate;
import com.revature.dao.hibernate.RoleHibernate;
import com.revature.dao.hibernate.UserHibernate;

public class DAOFactory {
	
	
	public static EventsDAO getEventsDAO() {
		// can also use EventsPostgres();
		return new EventsHibernate();
	}
	public static RoleDAO getRoleDAO() {
		//can also use RolePosgres();
		return new RoleHibernate();
	}
	
	public static UserDAO getUserDAO() {
		//can also use UserPostgres();
		return new UserHibernate();
	}
	
	
	
}
