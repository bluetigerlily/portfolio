package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.NonUniqueUsernameException;

public class RoleDelegate implements FrontControllerDelegate {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NonUniqueUsernameException, Exception {
		// TODO Auto-generated method stub
		
	}

}
