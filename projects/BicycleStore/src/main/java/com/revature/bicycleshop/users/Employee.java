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

public class Employee extends Manager {
	
	private static Integer empid;
	private static boolean bipending;
	private static String empusername;
	private static String emppassword;
	private static boolean employstatus;
	
	
	
	/* 
	 * Employee Variables
	 * 
	 * can do the same as a customer except has
	 * bipending - boolean will be true or false if true change biowned to true and enter payment plan if false rejet offer
	 *
	 * cususername - string to store the username variable 
	 * cuspassword - string to store the password variable
	 * biavailable - boolean will be true or false if true display to customer the bicycle is available if false don't display
	 * bioffer - Integer will be used to calculate paymentplan and paymentsremain
	 * biowned - boolean will be true or false if true display to customer the bicycle is owned if false don't display
	 * bimodel - Integer will be identifier of the bicycle type
	 * paymentplan - Integer will be the weekly number of payments required to pay off the price of bicycle
	 * paymentsmade - Integer will be number of weekly payments made to date
	 * paymentsremain - Integer number of payments remaining is (bioffer/paymentplan)-paymentsmade
	 * date - Integer to store the date
	 *employstatus -boolean if true employed if false not employed
	 */ 
	
	//getters and setters
	
	public Employee(boolean bipending, String empusername, String emppassword, boolean employstatus, Integer empid )
	{
		super();
		
		Employee.bipending = bipending;
		Employee.empusername = empusername;
		Employee.emppassword = emppassword;
		Employee.employstatus = employstatus;
		Employee.empid = empid;
	}
	public Employee() {
		
	}
	
	public static boolean isBipending() {
		return bipending;
	}

	public static void setBipending(boolean bipending) {
		Employee.bipending = bipending;
	}

	public static String getEmppassword() {
		return emppassword;
	}

	public static void setEmppassword(String emppassword) {
		Employee.emppassword = emppassword;
	}

	public String getEmpusername() {
		return empusername;
	}

	public static void setEmpusername(String empusername) {
		Employee.empusername = empusername;
	}

	public static boolean isEmploystatus() {
		return employstatus;
	}

	public static void setEmploystatus(boolean employstatus) {
		Employee.employstatus = employstatus;
	}
	public static Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		Employee.empid = empid;
	}
	
	
	 
	
}

	