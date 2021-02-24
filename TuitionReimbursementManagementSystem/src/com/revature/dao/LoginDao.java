package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import com.revature.tables.*;
import com.revature.connector.Connector;

public class LoginDao{

	private static Connector conn = Connector.getConnector();
	private static boolean status = false;
	Logger log = Logger.getLogger(LoginDao.class.getName());
	
	
	
public boolean Uservalidate(String username, String password) throws Exception{
		
		try (Connection con = conn.getConnection()) {	
			String sql ="SELECT FROM user WHERE (username, password) VALUES(?, ?)";
			con.setAutoCommit(false);
			User user = new User();
			PreparedStatement pmpt = con.prepareStatement(sql);
			pmpt.setString(1, user.getUsername());
			pmpt.setString(2, user.getPassword());
			ResultSet rs = pmpt.executeQuery();
			status = rs.next();

		} catch(Exception e){ System.out.println(e);}
	return status;	
	}

	
	}

