package com.revature.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import com.revature.connector.Connector;
import com.revature.tables.*;



public interface UserServices {

	
	Connector conn = Connector.getConnector();
	Logger log = Logger.getLogger(UserServices.class.getName());
	
	
	

	public static User updateUser(User user) throws Exception {
		
		
		
		
		
		return user;
		
	}

	public static User deleteUser(User user) throws Exception {
		
		
		
		return user;	
		
	}

	public static User CreateUser(User user) throws Exception {
		
		try (Connection con = conn.getConnection()) {	
		
		String sql ="INSERT INTO user (userid, username, password) VALUES(default, ?, ?)";
		String[] keys = {"cusid"};
		PreparedStatement pmpt = con.prepareStatement(sql, keys);
						con.setAutoCommit(false);	
				pmpt.setString(1, user.getUsername());
				pmpt.setString(2, user.getPassword());
				pmpt.executeUpdate();
				ResultSet rs = pmpt.getGeneratedKeys();
						
						while (rs.next()) {
							 User userzard = new User();
							User u = userzard;
							u.setUserid(rs.getInt(1));
							con.commit(); 
							if(u.equals(null)) {
								con.rollback(); } } 
					} catch (Exception e ) {
						if (e.getMessage().contains("violates unique username constraint")) {
							
		}
		
		
		
	} 
		return user;
	}

	public static User getUserbyEmail(User user) {
		
		
		
		
		
		return user;
		
		
	}
	
	}

	


