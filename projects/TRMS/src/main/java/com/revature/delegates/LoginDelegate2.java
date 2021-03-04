//package com.revature.delegates;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.exceptions.NonUniqueUsernameException;
//import com.revature.services.UserServicesImpl;
//
////purely for testing something
//
//
//	@WebServlet("/login")
//	public class LoginDelegate2 implements FrontControllerDelegate {
//		
//		
//		public void init() {
//		}
//		private UserServicesImpl userservicesimpl = new UserServicesImpl();
//		
//		protected void doGet(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//			response.sendRedirect("index.html");
//		}
//
//		protected void doPost(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//			try {
//				authenticate(request, response);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	
//	private void authenticate(HttpServletRequest req, HttpServletResponse resp)
//			throws Exception {
//		
//		resp.setContentType("text/html");
//	
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//
//		if (userservicesimpl.validate(username, password)) {
//			RequestDispatcher dispatcher = req.getRequestDispatcher("login was successful");
//			dispatcher.forward(req, resp);
//		}else {
//			throw new Exception("Login was not successful");
//		}
//	}
//
//	@Override
//	public void process(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException, NonUniqueUsernameException, Exception {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
