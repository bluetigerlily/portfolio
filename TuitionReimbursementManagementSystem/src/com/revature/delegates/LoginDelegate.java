package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.LoginDao;
import com.revature.services.UserServices;
import com.revature.tables.User;


public class LoginDelegate implements FrontControllerDelegate{
	
	
	private LoginDao Login = new LoginDao();
	private ObjectMapper om = new ObjectMapper();
	
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
				UserServices.CreateUser(user);
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
				LogIn(req, resp);
			else if ("DELETE".equals(req.getMethod()))
				req.getSession().invalidate();
			else
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		} else {
			userWithEmail(req, resp, String.valueOf(path));
		}
	}
	
	
	private void LogIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		String n = req.getParameter("username");
		String p = req.getParameter("password");
		
		try {
			if(Login.Uservalidate(n,p)) {
				RequestDispatcher rd = req.getRequestDispatcher("default.html");
				rd.forward(req, resp);
			}else {
				out.print("sorry username or password error");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			}}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	} 
		}
	
		
	
	
	private void userWithEmail(HttpServletRequest req, HttpServletResponse resp, String useremail) throws Exception {
		switch (req.getMethod()) {
			case "GET":
				User user = new User();
				user.setUseremail(useremail);
				UserServices.getUserbyEmail(user);
				if (useremail != null) {
					resp.getWriter().write(om.writeValueAsString(useremail));
				} else {
					resp.sendError(404, "User not found.");
				}
				break;
			case "PUT":
				String password = req.getParameter("password");
				User userzard = (User) req.getSession().getAttribute("username");
				if (userzard != null) {
					userzard.setPassword(password);
					UserServices.updateUser(userzard);
				} else
					resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				break;
			case "DELETE":
				 user = om.readValue(req.getInputStream(), User.class);
				UserServices.deleteUser(user);
				break;
			default:
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				break;
		}
	}




	


}
