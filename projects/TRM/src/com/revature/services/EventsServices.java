package com.revature.services;

import com.revature.beans.Events;
import com.revature.beans.User;

public interface EventsServices {

	Events getAllEvents(int userid) throws Exception;

	public Events addEvent(Events events) throws Exception;

	void UpdateEvents(Events e) throws Exception;

	User getAllEvents() throws Exception;
}
