package com.revature.delegates;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Events;
import com.revature.beans.Role;
import com.revature.beans.User;
import com.revature.services.EventsServicesImpl;
import com.revature.services.RolesServicesImpl;
import com.revature.services.UserServicesImpl;

public class EventsDelegate implements FrontControllerDelegate {

	private ObjectMapper om = new ObjectMapper();
	private UserServicesImpl userservicesimpl = new UserServicesImpl();
	private EventsServicesImpl eventservicesimpl = new EventsServicesImpl();
	private RolesServicesImpl roleservicesimpl = new RolesServicesImpl();
	User user = new User();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String path = (String) req.getAttribute("path"); 
		
		if (path == null || path.equals("")) { 
			switch (req.getMethod()) {
				case "POST":
					// add an event
					User u = new User();
					Events e = om.readValue(req.getInputStream(), Events.class); 
					u.setId(userservicesimpl.addEvent(e)); 
					resp.getWriter().write(om.writeValueAsString(e));
					resp.setStatus(HttpServletResponse.SC_CREATED);
					break;
				case "GET":
					resp.getWriter().write(
							om.writeValueAsString(eventservicesimpl.getPendingEvents()));
					break;
				default:
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}
		} else if (path.contains("approve")) {
			if ("POST".equals(req.getMethod())) {
				Events e = (Events) om.readValue(req.getInputStream(), Events.class);
				User u = (User) req.getSession().getAttribute("user");
				try {
					userservicesimpl.approveEvents(u, e);
				} catch (Exception EVENTALREADYAPPROVED) {
					resp.sendError(HttpServletResponse.SC_CONFLICT, "Event was already approved");
				}
				resp.getWriter().write(om.writeValueAsString(e));
				resp.setStatus(HttpServletResponse.SC_ACCEPTED);
			} else {
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			}
		} else {
			int eventid = Integer.valueOf(path);
			Events e = null;
			switch (req.getMethod()) {
				case "GET":
					e = eventservicesimpl.getEventById(eventid);
					if (e != null) 
						resp.getWriter().write(om.writeValueAsString(e));
					else
						resp.sendError(404, "Event not found.");
					break;
				case "PUT":
					if (isBossMan((User) (req.getSession().getAttribute("userid")), (Role) req.getSession().getAttribute("roleid"))) {
					
						 e = om.readValue(req.getInputStream(), Events.class);
						userservicesimpl.updateEvents(e);
						resp.getWriter().write(om.writeValueAsString(e));
					} else {
						resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
					}
					break;
				case "DELETE":
					if (isBossMan((User) (req.getSession().getAttribute("userid")), (Role) req.getSession().getAttribute("roleid"))) {
						e = om.readValue(req.getInputStream(), Events.class);
						eventservicesimpl.removeEvents(e);
					} else {
						resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
					}
					break;
				default:
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}			
		}
	}
	
	private boolean isBossMan(User userid, Role roleid) {
		User u = new User();
		Role r = new Role();
		
		try {
			if (((r != null && userservicesimpl.getRolebyId().equals("directsuperemp"))) && ((u != null) && (userservicesimpl.getUserbyId() == roleservicesimpl.getRolebyId()))) {
				return true;
			}
				else if (((r != null && userservicesimpl.getRolebyId().equals("directsuperbenco"))) && ((u != null) && (userservicesimpl.getUserbyId() == roleservicesimpl.getRolebyId()))) {
					return true;
				}
					else if (((r != null && userservicesimpl.getRolebyId().equals("departmenthead"))) && ((u != null) && (userservicesimpl.getUserbyId() == roleservicesimpl.getRolebyId()))) {
						return true;
					}
						else if (((r != null && userservicesimpl.getRolebyId().equals("benco"))) && ((u != null) && (userservicesimpl.getUserbyId() == roleservicesimpl.getRolebyId()))) {
							return true;
						}
							else if (((r != null && userservicesimpl.getRolebyId().equals("employee"))) && ((u != null) && (userservicesimpl.getUserbyId() == roleservicesimpl.getRolebyId()))) {
			return false;
							}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}