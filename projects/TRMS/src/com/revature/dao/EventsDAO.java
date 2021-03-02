package com.revature.dao;

import com.revature.beans.Events;

public interface EventsDAO extends GenericDAO<Events> {

	Events getEventbyUserid(int userid) throws Exception;

}
