package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Events;
import com.revature.beans.User;
import com.revature.exceptions.NonUniqueUsernameException;
import com.revature.services.EventsServicesImpl;
import com.revature.services.UserServicesImpl;

public class EventsDelegate implements FrontControllerDelegate {
	
	private ObjectMapper om = new ObjectMapper();
	private UserServicesImpl userservicesimpl = new UserServicesImpl();
	private EventsServicesImpl eventservicesimpl = new EventsServicesImpl();
	 User user = new User();
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NonUniqueUsernameException, Exception {
		
		String path = (String) req.getAttribute("path");
		
		
		if(path.contains("events")) {
			switch(req.getMethod()) {
			case "GET":
			 user = eventservicesimpl.getAllEvents();
				resp.getWriter().write(om.writeValueAsString((user)));
				break;
			case "POST":
				Events events = new Events();
				events = om.readValue(req.getInputStream(), Events.class);
				eventservicesimpl.addEvent(events);
				break;
			case "PUT":
				Events eventss = new Events();
				int userid = 0;
				user = userservicesimpl.getUserbyUserid(userid);
				if (user != null) {
					req.getSession().setAttribute("events", userid);
					resp.getWriter().write(om.writeValueAsString(eventss));
				} else {
					resp.sendError(404, "No event existed please fill out a new form");
				}			
				break;
			default:
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				break;
				
			}
		}
		else if (path.contains("role")) {
			switch(req.getMethod()) {
			case "GET":
				 user = userservicesimpl.getRole();
				 resp.getWriter().write(om.writeValueAsString(user));
				 break;
			case "POST":
				userservicesimpl.addRole();
				break;
			default:
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				break;
			}
		}
		else {
			resp.sendError(404);
		}
		
		
	}

}
