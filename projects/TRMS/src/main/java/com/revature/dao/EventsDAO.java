package com.revature.dao;

import org.hibernate.mapping.List;

import com.revature.beans.Events;
import com.revature.beans.User;

public interface EventsDAO extends GenericDAO<Events> {

	Events getEventbyId(int id) throws Exception;
	List Events() throws Exception;
	void saveEvents(com.revature.beans.Events e) throws Exception;
	User getbyId(int i);
	
}
