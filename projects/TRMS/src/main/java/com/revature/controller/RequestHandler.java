package com.revature.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.delegates.EventsDelegate;
import com.revature.delegates.FrontControllerDelegate;
import com.revature.delegates.LoginDelegate;
import com.revature.delegates.RoleDelegate;

public class RequestHandler {
	private Map<String, FrontControllerDelegate> delegateMap; 
	{
		delegateMap = new HashMap<String, FrontControllerDelegate>();

		delegateMap.put("user", new LoginDelegate());
		delegateMap.put("role", new RoleDelegate());
		delegateMap.put("events", new EventsDelegate());   
		}

	public FrontControllerDelegate handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if ("OPTIONS".equals(req.getMethod())) {
			return (r1, r2) -> {};
		}
		
	
		StringBuilder uriString = new StringBuilder(req.getRequestURI());
		
		
	
		uriString.replace(0, req.getContextPath().length()+1, "");
		
		
		if (uriString.indexOf("/") != -1) {
			req.setAttribute("path", uriString.substring(uriString.indexOf("/")+1));
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
			
		}
		
		return delegateMap.get(uriString.toString());
	}
}

