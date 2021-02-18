package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Bean;

@SuppressWarnings("serial")
public class BeanServlet extends HttpServlet{

	
	private static ObjectMapper om = new ObjectMapper();
	
	
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			Bean bean = new Bean();
			
			resp.getWriter().write(bean.toString());
		}
	
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		Bean bean = om.readValue(req.getInputStream(), Bean.class);
		
		resp.getWriter().write("<table>"
				+ "<th><td>Name</td><td>Weight</td><td>Flavor</td></th>"
				+ "<td>" + bean.getName() + "</td>"
						+ "<td>" + bean.getWeight() + "</td>"
								+ "<td>" + bean.getFlavor() + "</td></tr>"
										+ "</table>");
		
	}
	}


