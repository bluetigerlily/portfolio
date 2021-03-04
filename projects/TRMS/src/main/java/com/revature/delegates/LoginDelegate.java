package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.UserServices;
import com.revature.services.UserServicesImpl;

public class LoginDelegate implements FrontControllerDelegate {

	private ObjectMapper om = new ObjectMapper();
	private UserServicesImpl userservicesimpl = new UserServicesImpl();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) {

		String path = (String) req.getAttribute("path");
		if (path == null || path.equals("")) {
			if ("POST".equals(req.getMethod())) {
				// register a new user
				User user = new User();
				try {
					user = (User) om.readValue(req.getInputStream(), UserServices.class);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String n = req.getParameter("username");
				String p = req.getParameter("password");
				user.setPassword(p);
				user.setUsername(n);
				try {
					userservicesimpl.CreateUser(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (user.getId() == 0) {
					resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				} else {
					try {
						resp.getWriter().write(om.writeValueAsString(user));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					resp.setStatus(HttpServletResponse.SC_CREATED);
				}
			} else {
				try {
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (path.contains("login")) {
			if ("POST".equals(req.getMethod()))
				try {
					Login(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else if ("DELETE".equals(req.getMethod()))
				req.getSession().invalidate();
			else
				try {
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} else {
			try {
				userWithUsername(req, resp, String.valueOf(path));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	private void Login(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		resp.setContentType("text/html");
User user = new User();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("step 0");
		 user = userservicesimpl.getUserbyUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {  
				System.out.println("step 0");
				req.getSession().setAttribute("user", user);
				resp.getWriter().write(om.writeValueAsString(user));
			} else {
				resp.sendError(404, "Incorrect password.");
			}
		} else {
			resp.sendError(404, "No user found with that username.");
		System.out.println("login method broken");
		}
	}
	

	private void userWithUsername(HttpServletRequest req, HttpServletResponse resp, String username) throws Exception {
		switch (req.getMethod()) {
		case "GET":
			User user = new User();
			user = userservicesimpl.getUserbyUsername(username);
			if (user != null) {
				resp.getWriter().write(om.writeValueAsString(user));
			} else {
				resp.sendError(404, "User not found.");
			}
			break;
		case "PUT":
			String password = req.getParameter("password");
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
	
	
	
	
	
	

	
	
	

	


