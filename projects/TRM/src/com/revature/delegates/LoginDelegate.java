package com.revature.delegates;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.UserServices;
import com.revature.services.UserServicesImpl;

public class LoginDelegate implements FrontControllerDelegate {

	private ObjectMapper om = new ObjectMapper();
	private UserServicesImpl userservicesimpl = new UserServicesImpl();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String path = (String) req.getAttribute("path");
		if (path == null || path.equals("")) {
			if ("POST".equals(req.getMethod())) {
				// register a new user
				User user = new User();
				user = (User) om.readValue(req.getInputStream(), UserServices.class);
				String n = req.getParameter("username");
				String p = req.getParameter("password");
				user.setPassword(p);
				user.setUsername(n);
				userservicesimpl.CreateUser(user);
				if (user.getUserid() == 0) {
					resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				} else {
					resp.getWriter().write(om.writeValueAsString(user));
					resp.setStatus(HttpServletResponse.SC_CREATED);
				}
			} else {
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			}
		} else if (path.contains("login")) {
			if ("POST".equals(req.getMethod()))
				Login(req, resp);
			else if ("DELETE".equals(req.getMethod()))
				req.getSession().invalidate();
			else
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		} else {
			userWithUsername(req, resp, String.valueOf(path));
		}
	}

	private void Login(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		resp.setContentType("text/html");

		String n = req.getParameter("username");
		String p = req.getParameter("password");

		User u = userservicesimpl.getUserbyUsername(n);
		if (u != null) {
			if (u.getPassword().equals(p)) {
				req.getSession().setAttribute("user", u);
				resp.getWriter().write(om.writeValueAsString(u));
			} else {
				resp.sendError(404, "Incorrect password.");
			}
		} else {
			resp.sendError(404, "No user found with that username.");
		}
	}

	private void userWithUsername(HttpServletRequest req, HttpServletResponse resp, String username) throws Exception {
		switch (req.getMethod()) {
		case "GET":
			User user = new User();
			userservicesimpl.getUserbyUsername(username);
			if (username != null) {
				resp.getWriter().write(om.writeValueAsString(username));
			} else {
				resp.sendError(404, "User not found.");
			}
			break;
		case "PUT":
			String password = req.getParameter("password");
			user = (User) req.getSession().getAttribute("username");
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
