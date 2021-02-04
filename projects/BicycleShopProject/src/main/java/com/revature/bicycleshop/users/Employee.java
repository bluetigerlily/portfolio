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

public class Employee{

	
	private static String cususername;
	private static String cuspassword;
	private static boolean biavailable;
	private static int bioffer;
	private static boolean biowned;
	public static int bimodel;
	private static int paymentplan;
	private static int paymentsmade;
	private static int paymentsremain;
	public static int date;
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
	 * bioffer - int will be used to calculate paymentplan and paymentsremain
	 * biowned - boolean will be true or false if true display to customer the bicycle is owned if false don't display
	 * bimodel - int will be identifier of the bicycle type
	 * paymentplan - int will be the weekly number of payments required to pay off the price of bicycle
	 * paymentsmade - int will be number of weekly payments made to date
	 * paymentsremain - int number of payments remaining is (bioffer/paymentplan)-paymentsmade
	 * date - int to store the date
	 *employstatus -boolean if true employed if false not employed
	 */ 
	
	//getters and setters
	
	public Employee(String cususername, String cuspassword, boolean biavailable, int bioffer, boolean biowned, int bimodel,int paymentplan, int paymentsmade, int paymentsremain, int date, boolean bipending, String empusername, String emppassword, boolean employstatus )
	{
		super();
		Employee.cususername = cususername;
		Employee.cuspassword = cuspassword;
		Employee.biavailable = biavailable;
		Employee.bioffer = bioffer;
		Employee.biowned = biowned;
		Employee.bimodel = bimodel;
		Employee.paymentplan = paymentplan;
		Employee.paymentsmade = paymentsmade;
		Employee.paymentsremain = paymentsremain;
		Employee.date = date;
		Employee.setBipending(bipending);
		Employee.setEmpusername(empusername);
		Employee.setEmppassword(emppassword);
		Employee.setEmploystatus(employstatus);		
	}
	
	public static String getCususername() {
		return cususername;
	}
	public static void setCususername(String cususername) {
		Employee.cususername = cususername;
	}
	public static String getCuspassword() {
		return cuspassword;
	}
	public static void setCuspassword(String cuspassword) {
		Employee.cuspassword = cuspassword;
	}
	public static boolean isBiavailable() {
		return biavailable;
	}
	public static void setBiavailable(boolean biavailable) {
		Employee.biavailable = biavailable;
	}
	public static int getBioffer() {
		return bioffer;
	}
	public static void setBioffer(int bioffer) {
		Employee.bioffer = bioffer;
	}
	public static boolean isBiowned() {
		return biowned;
	}
	public static void setBiowned(boolean biowned) {
		Employee.biowned = biowned;
	}
	public static int getPaymentplan() {
		return paymentplan;
	}
	public static void setPaymentplan(int paymentplan) {
		Employee.paymentplan = paymentplan;
	}
	public static int getPaymentsmade() {
		return paymentsmade;
	}
	public static void setPaymentsmade(int paymentsmade) {
		Employee.paymentsmade = paymentsmade;
	}
	public static int getPaymentsremain() {
		return paymentsremain;
	}
	public static void setPaymentsremain(int paymentsremain) {
		Employee.paymentsremain = paymentsremain;
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

	public static String getEmpusername() {
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
	
	 
	
}
