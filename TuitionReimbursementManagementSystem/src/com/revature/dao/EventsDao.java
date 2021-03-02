package com.revature.dao;
import com.revature.beans.*;

public interface EventsDAO extends GenericDAO<Events>{

	Events getEventbyUserid(int userid) throws Exception;

	
}
