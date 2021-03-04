package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.delegates.FrontControllerDelegate;
import com.revature.exceptions.NonUniqueUsernameException;

/**
 * Servlet implementation class FrontController
 */

@SuppressWarnings("serial")
public class FrontController extends DefaultServlet {
	private RequestHandler rh = new RequestHandler();

	/**
	 * Default constructor.
	 * 
	 * @throws Exception
	 * @throws NonUniqueUsernameException
	 */
//	private void process(HttpServletRequest req, HttpServletResponse resp)
//			throws NonUniqueUsernameException, Exception {
//		FrontControllerDelegate fcd = rh.handle(req, resp);
//		System.out.println("Test Test Test");
//
//		if (req.getRequestURI().substring(req.getContextPath().length()).startsWith("/static")) {
//			super.doGet(req, resp);
//		} else {
//			if (fcd != null)
//				fcd.process(req, resp);
//			else
//				resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//		}
//	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp)
            throws NonUniqueUsernameException, Exception {
        FrontControllerDelegate fcd = rh.handle(req, resp);
        System.out.println("Test Test Test");

        if (fcd != null)
            fcd.process(req, resp);
        else
            super.doGet(req, resp);
    }
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			process(request, response);
		} catch (NonUniqueUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			process(req, resp);
		} catch (NonUniqueUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			process(request, response);
		} catch (NonUniqueUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			process(req, resp);
		} catch (NonUniqueUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			process(req, resp);
		} catch (NonUniqueUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
