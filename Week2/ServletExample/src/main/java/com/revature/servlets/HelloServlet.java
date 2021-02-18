package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6611002305141965942L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Hello!</h1><p style =\"color:green\">Welcome to the Servlet Example!</p>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		@SuppressWarnings("unused")
		String firstName = req.getParameter("firstname");
		@SuppressWarnings("unused")
		String lastName = req.getParameter("lastname");
		
		@SuppressWarnings("unused")
		PrintWriter a = resp.getWriter();
		
	}
	}
