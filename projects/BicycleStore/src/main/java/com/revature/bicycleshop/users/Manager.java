package com.revature.bicycleshop.users;

import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Wrapper;
import java.util.*;
import java.util.concurrent.Executor;
import com.revature.bicycleshop.interfaces.*;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;


public class Manager {
	
	
	
	private static Integer manid;
	private static String manusername;
	private static String manpassword;
	private static Integer sales;
	private static Integer missedsales;
	
	
	
	//getters and setters
	
	
	public Manager(Integer manid, String manusername, String manpassword, Integer sales, Integer missedsales)
	{
		super();
		Manager.setManid(manid);
		Manager.manusername = manusername;
		Manager.manpassword = manpassword;
		Manager.sales = sales;
		Manager.missedsales = missedsales;
	}
	
	public Manager() {
		
	}
	
	

	public static String getManpassword() {
		return manpassword;
	}
	public void setManpassword(String manpassword) {
		Manager.manpassword = manpassword;
	}
	public String getManusername() {
		return manusername;
	}
	public void setManusername(String manusername) {
		Manager.manusername = manusername;
	}
	public static Integer getSales() {
		return sales;
	}
	public static void setSales(Integer sales) {
		Manager.sales = sales;
	}
	public static Integer getMissedsales() {
		return missedsales;
	}
	public static void setMissedsales(Integer missedsales) {
		Manager.missedsales = missedsales;
	}

	public static Integer getManid() {
		return manid;
	}

	public static void setManid(Integer manid) {
		Manager.manid = manid;
	}

	
	
	
	
	
	
	
	
	
	
	
	//have to make these
	
	
	
	
	

	public void setEmpusername(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	public void setEmployee(Manager createEmployee) {
		// TODO Auto-generated method stub
		
	}

	public String getEmpusername() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmppassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmppassword(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	
	/* Manager Variables
	 * empusername - string to store the username variable of an employee
	 * emppassword - string to store the password variable of an employee
	 * manusername - string to store the username variable of a manager
	 * manpassword - string to store the password variable of a manager
	 * employment status - boolean if true you're employed if false you're fired
	 * sales - Integer shows the number of bioffer which were bipending switched to true
	 * missedsales - Integer shows the number of bioffer which were bioffer which were bipending switched to false
	 */
	
}