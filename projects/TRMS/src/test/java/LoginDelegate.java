

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.delegates.FrontControllerDelegate;
import com.revature.services.UserServices;
import com.revature.services.UserServicesImpl;

public class LoginDelegate implements FrontControllerDelegate {

	private ObjectMapper om = new ObjectMapper();
	private UserServicesImpl userservicesimpl = new UserServicesImpl();

	public void process(HttpServletRequest req, HttpServletResponse resp) {

		String path = (String) req.getAttribute("path");
		if (path == null || path.equals("")) {
			if ("POST".equals(req.getMethod())) {
				// register a new user
				User user = new User();
				try {
					user = (User) om.readValue(req.getInputStream(), UserServices.class);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String n = req.getParameter("username");
				String p = req.getParameter("password");
				user.setPassword(p);
				user.setUsername(n);
				try {
					userservicesimpl.CreateUser(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (user.getId() == 0) {
					resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				} else {
					try {
						resp.getWriter().write(om.writeValueAsString(user));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					resp.setStatus(HttpServletResponse.SC_CREATED);
				}
			} else {
				try {
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (path.contains("login")) {
			if ("POST".equals(req.getMethod()))
				try {
					Login(req, resp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			else if ("DELETE".equals(req.getMethod()))
				req.getSession().invalidate();
			else
				try {
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} else {
			try {
				userWithUsername(req, resp, String.valueOf(path));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	private void Login(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		resp.setContentType("text/html");

		String n = req.getParameter("username");
		String p = req.getParameter("password");
		System.out.println("step 0");
		User u = userservicesimpl.getUserbyUsername(n);
		if (u != null) {
			if (u.getPassword().equals(p)) {  
				System.out.println("step 0");
				req.getSession().setAttribute("user", u);
				resp.getWriter().write(om.writeValueAsString(u));
			} else {
				resp.sendError(404, "Incorrect password.");
			}
		} else {
			resp.sendError(404, "No user found with that username.");
		System.out.println("login method broken");
		}
	}
	

	private void userWithUsername(HttpServletRequest req, HttpServletResponse resp, String username) throws Exception {
		switch (req.getMethod()) {
		case "GET":
			User user = new User();
			userservicesimpl.getUserbyUsername(username);
			if (username != null) {
				resp.getWriter().write(om.writeValueAsString(username));
			} else {
				resp.sendError(404, "User not found.");
			}
			break;
		case "PUT":
			String password = req.getParameter("password");
			user = (User) req.getSession().getAttribute("username");
			if (user != null) {
				user.setPassword(password);
				userservicesimpl.updateUser(user);
			} else
				resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			break;
		case "DELETE":
			user = om.readValue(req.getInputStream(), User.class);
			userservicesimpl.deleteUser(user);
			break;
		default:
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			break;
		
		
		}
	
	
	}
}
	
	
	
	
	
	

	
	
	

	


