package com.revature.bicycleshop.connector;


	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.Connection;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.Wrapper;
	import java.util.Scanner;
	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;
	import org.postgresql.Driver;
	import java.sql.Connection;
	import java.util.*;
	import java.sql.CallableStatement;
	import java.sql.ResultSet;


	public class Connector {
		
		
			private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());
			public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
			public static final String USER = "postgres";
			public static final String PASS = "4271";

		public void main1 (String[]args)
		{
			new Connector();
		}

			public static Connection get_connection()
			{
					
				
			try 
			
				{
				
				
				DriverManager.registerDriver(new Driver());
				
				return DriverManager.getConnection(URL,USER,PASS);
				
				
				}	
				
			catch (SQLException ex) 
				{
					throw new RuntimeException("Error in connecting  to PostgresSQL server ",ex);
					
				}
			}
			//testing the connection
			public static void main(String[]args)
			{
				System.out.println("Connected to SQL Server");
			}


			}
