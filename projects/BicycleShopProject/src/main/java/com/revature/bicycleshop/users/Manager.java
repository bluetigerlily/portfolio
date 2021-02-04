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


public class Manager{

	
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
	private static String manusername;
	private static String manpassword;
	private static int sales;
	private static int missedsales;
	
	
	
	//getters and setters
	
	
	public Manager(String cususername, String cuspassword, boolean biavailable, int bioffer, boolean biowned,int bimodel, int paymentplan, int paymentsmade, int paymentsremain, int date, boolean bipending, String empusername, String emppassword, boolean employstatus, String manusername, String manpassword, int sales, int missedsales)
	{
		super();
		Manager.cususername = cususername;
		Manager.cuspassword = cuspassword;
		Manager.biavailable = biavailable;
		Manager.bioffer = bioffer;
		Manager.bimodel = bimodel;
		Manager.paymentplan = paymentplan;
		Manager.paymentsmade = paymentsmade;
		Manager.paymentsremain = paymentsremain;
		Manager.date = date;
		Manager.bipending = bipending;
		Manager.empusername = empusername;
		Manager.emppassword = emppassword;
		Manager.employstatus = employstatus;
		Manager.manusername = manusername;
		Manager.manpassword = manpassword;
		Manager.sales = sales;
		Manager.missedsales = missedsales;
	}
	public static String getCususername() {
		return cususername;
	}
	public static void setCususername(String cususername) {
		Manager.cususername = cususername;
	}
	public static String getCuspassword() {
		return cuspassword;
	}
	public static void setCuspassword(String cuspassword) {
		Manager.cuspassword = cuspassword;
	}
	public static boolean isBiavailable() {
		return biavailable;
	}
	public static void setBiavailable(boolean biavailable) {
		Manager.biavailable = biavailable;
	}
	public static int getBioffer() {
		return bioffer;
	}
	public static void setBioffer(int bioffer) {
		Manager.bioffer = bioffer;
	}
	public static boolean isBiowned() {
		return biowned;
	}
	public static void setBiowned(boolean biowned) {
		Manager.biowned = biowned;
	}
	public static int getPaymentplan() {
		return paymentplan;
	}
	public static void setPaymentplan(int paymentplan) {
		Manager.paymentplan = paymentplan;
	}
	public static int getPaymentsmade() {
		return paymentsmade;
	}
	public static void setPaymentsmade(int paymentsmade) {
		Manager.paymentsmade = paymentsmade;
	}
	public static int getPaymentsremain() {
		return paymentsremain;
	}
	public static void setPaymentsremain(int paymentsremain) {
		Manager.paymentsremain = paymentsremain;
	}
	public static boolean isBipending() {
		return bipending;
	}
	public static void setBipending(boolean bipending) {
		Manager.bipending = bipending;
	}
	public static String getEmppassword() {
		return emppassword;
	}
	public static void setEmppassword(String emppassword) {
		Manager.emppassword = emppassword;
	}
	public static String getEmpusername() {
		return empusername;
	}
	public static void setEmpusername(String empusername) {
		Manager.empusername = empusername;
	}
	public static boolean isEmploystatus() {
		return employstatus;
	}
	public static void setEmploystatus(boolean employstatus) {
		Manager.employstatus = employstatus;
	}
	public static String getManpassword() {
		return manpassword;
	}
	public static void setManpassword(String manpassword) {
		Manager.manpassword = manpassword;
	}
	public static String getManusername() {
		return manusername;
	}
	public static void setManusername(String manusername) {
		Manager.manusername = manusername;
	}
	public static int getSales() {
		return sales;
	}
	public static void setSales(int sales) {
		Manager.sales = sales;
	}
	public static int getMissedsales() {
		return missedsales;
	}
	public static void setMissedsales(int missedsales) {
		Manager.missedsales = missedsales;
	}
	
	/* Manager Variables
	 * empusername - string to store the username variable of an employee
	 * emppassword - string to store the password variable of an employee
	 * manusername - string to store the username variable of a manager
	 * manpassword - string to store the password variable of a manager
	 * employment status - boolean if true you're employed if false you're fired
	 * sales - int shows the number of bioffer which were bipending switched to true
	 * missedsales - int shows the number of bioffer which were bioffer which were bipending switched to false
	 */
	
}
