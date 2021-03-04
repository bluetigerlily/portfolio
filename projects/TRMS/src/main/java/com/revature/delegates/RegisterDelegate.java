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
//import com.revature.beans.User;
//import com.revature.dao.hibernate.UserHibernate;
//import com.revature.exceptions.NonUniqueUsernameException;

//@WebServlet("/register")
//	public class RegisterDelegate implements FrontControllerDelegate {
//		private UserHibernate userhibernate = new UserHibernate();
//		public void init() {
//			
//		}
//
//		protected void doPost(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//			register(request, response);
//		}
//
//		protected void doGet(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//			response.sendRedirect("register.html");
//		}
//
//		private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//			String firstName = request.getParameter("firstName");
//			String lastName = request.getParameter("lastName");
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			
//			User user = new User();
//			
//			user.setFirstname(firstName);
//			user.setLastname(lastName);
//			user.setUsername(username);
//			user.setPassword(password);
//
//			try {
//				userhibernate.save(user);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
//			dispatcher.forward(request, response);
//		}
//
//		@Override
//		public void process(HttpServletRequest req, HttpServletResponse resp)
//				throws ServletException, IOException, NonUniqueUsernameException, Exception {
//			// don't think I need this one
//			
//		}
//	}



