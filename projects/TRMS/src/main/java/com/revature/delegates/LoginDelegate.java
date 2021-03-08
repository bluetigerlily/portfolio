package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.exceptions.NonUniqueUsernameException;
import com.revature.services.UserServicesImpl;

public class LoginDelegate implements FrontControllerDelegate {

	private ObjectMapper om = new ObjectMapper();
	private UserServicesImpl userservicesimpl = new UserServicesImpl();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = (String) req.getAttribute("path");
		
		if (path == null || path.equals("")) {
			if ("POST".equals(req.getMethod())) {
				// register a user
				User u = (User) om.readValue(req.getInputStream(), User.class);
				try {
					u.setId(userservicesimpl.addUser(u));
				} catch (NonUniqueUsernameException e) {
					resp.sendError(HttpServletResponse.SC_CONFLICT, "Username already exists");
				}
				if (u.getId() == 0) {
					resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				} else {
					resp.getWriter().write(om.writeValueAsString(u));
					resp.setStatus(HttpServletResponse.SC_CREATED);
				}
			} else if ("GET".equals(req.getMethod())) {
				User u = (User) req.getSession().getAttribute("user");
				resp.getWriter().write(om.writeValueAsString(u));
				resp.setStatus(200);
			} else {
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			}
		} else if (path.contains("login")) {
			if ("POST".equals(req.getMethod()))
				logIn(req, resp);
			else if ("DELETE".equals(req.getMethod()))
				req.getSession().invalidate();
			else
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		} else {
			try {
				userWithId(req, resp, Integer.valueOf(path));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	private void logIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		
		User u = null;
		try {
			u = userservicesimpl.getUserbyUsername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u != null) {
			if (u.getPassword().equals(password)) {
				req.getSession().setAttribute("user", u);
				resp.getWriter().write(om.writeValueAsString(u));
			} else {
				resp.sendError(404, "Incorrect password.");
			}
		} else {
			resp.sendError(404, "No user found with that username.");
		}
	}
	

	private void userWithId(HttpServletRequest req, HttpServletResponse resp, Integer id) throws Exception {
		switch (req.getMethod()) {
			case "GET":
				User user = userservicesimpl.getUserbyId(id);
				if (user != null) {
					resp.getWriter().write(om.writeValueAsString(user));
				} else {
					resp.sendError(404, "User not found.");
				}
				break;
			case "PUT":
				String password = req.getParameter("pass");
				 user = (User) req.getSession().getAttribute("user");
				if (user != null) {
					user.setPassword(password);
					userservicesimpl.updateUser(user);
				} else
					resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				break;
			case "DELETE":
				user = om.readValue(req.getInputStream(), User.class);
				userservicesimpl.deleteUser(user);
				break;
			default:
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				break;
		}
	}

}

	
	
	
	
	

	
	
	

	


