package com.revature.controller;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.EventsDelegate;
import com.revature.delegates.FrontControllerDelegate;
import com.revature.delegates.LoginDelegate;
import com.revature.delegates.RoleDelegate;

public class RequestHandler {
	private Map<String, FrontControllerDelegate> delegateMap;  {
		delegateMap = new HashMap<String, FrontControllerDelegate>();

		delegateMap.put("user", new LoginDelegate());
		delegateMap.put("role", new RoleDelegate());
		delegateMap.put("events", new EventsDelegate());    }

public FrontControllerDelegate handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// if the request is an options request
		// return empty delegate
		if ("OPTIONS".equals(req.getMethod())) {
			return (r1, r2) -> {};
		}
		// if  uriString = localhost:8080/tuitionreimbursementmanagementsystem/something
		// getting the URI from the request
		StringBuilder uriString = new StringBuilder(req.getRequestURI());
		//uristring = tuitionreimbursementmanagementsystem/something
		// get rid of the first part of the URL
		uriString.replace(0, req.getContextPath().length()+1, "");
		//then its one more than the substring so its tuitionreimbursementmanagementsystem as my uristring 
		//finally understand this lol
		if (uriString.indexOf("/") != -1) {
			req.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");

		}

		if (req.getRequestURI().toLowerCase().contains("user")) {
            return new LoginDelegate();
        }
		System.out.println(uriString.toString());
		return delegateMap.get(uriString.toString());

			}}
