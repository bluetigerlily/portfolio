package com.revature.delegates;


import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Role;
import com.revature.services.RoleServices;
import com.revature.services.RolesServicesImpl;
import com.revature.services.UserServices;
import com.revature.services.UserServicesImpl;

public class RoleDelegate implements FrontControllerDelegate {
	/*
	 * Endpoints:
	 *
	 *  /user/role - (GET) returns all of the roles a user can have
	 *  
	 */
	private UserServices userv = new UserServicesImpl();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws Exception 
	{
		String path = (String) req.getAttribute("path");
		if (path.contains("role")) {
			switch (req.getMethod()) {
			case "GET":
				Set<Role> roles = userv.getAllRoles();
				resp.getWriter().write(om.writeValueAsString(roles));
				break;
			default:
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				break;
		}
		

	}
	}
}


	
		
	
