package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.beans.Events;
import com.revature.beans.User;
import com.revature.dao.DAOFactory;
import com.revature.dao.EventsDAO;

public class EventsServicesImpl implements EventsServices {
	private EventsDAO eventsdao;
	private static Logger Log = Logger.getLogger(EventsServicesImpl.class);

	public EventsServicesImpl() {
		DAOFactory.getUserDAO();
		DAOFactory.getRoleDAO();
		eventsdao = DAOFactory.getEventsDAO();
	}

	@Override
	public Events getAllEvents(int id) throws Exception {
		return eventsdao.getEventbyId(id);
	}

	@Override
	public Events addEvent(Events events) throws Exception {
		return eventsdao.add(events);
	}

	@Override
	public void UpdateEvents(Events e) throws Exception {
		int id = 0;
		if (eventsdao.getEventbyId(id) != null)
			eventsdao.update(e);
		else
			Log.debug("Event was never created by someone under that id. ");

	}

	@Override
	public User getAllEvents() throws Exception {
		return eventsdao.getAll();
	}

}
