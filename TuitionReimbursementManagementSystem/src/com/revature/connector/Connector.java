package com.revature.connector;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class Connector {

		
		private static Connector conn = null;
		private static Properties props;

	private Connector() {
		props = new Properties();				
		try 
			{
			
			InputStream dbProps = Connector.class.getClassLoader().
			getResourceAsStream("database.properties");
			props.load(dbProps);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static synchronized Connector  getConnector() {
		if (conn == null)
			conn = new Connector();
		return conn;
	
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(props.getProperty("DRIVER"));
			con = DriverManager.getConnection(
					props.getProperty("URL"),
					props.getProperty("USER"),
					props.getProperty("PASS")
					);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}

					
	
