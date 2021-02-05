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





public class Customer{
	
	//going to use Customer as my generic customer user
	/*
	 * Customer Variables
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
	 */
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

	
	//getters and setters
	
	public Customer(String cususername, String cuspassword, boolean biavailable, int bioffer, boolean biowned, int bimodel, int paymentplan, int paymentsmade, int paymentsremain, int date)
	{
		super();
		Customer.cususername = cususername;
		Customer.cuspassword = cuspassword;
		Customer.biavailable = biavailable;
		Customer.bioffer = bioffer;
		Customer.biowned = biowned;
		Customer.bimodel = bimodel;
		Customer.paymentplan = paymentplan;
		Customer.paymentsmade = paymentsmade;
		Customer.paymentsremain = paymentsremain;
		Customer.date = date;		
	}
		
	
	
	
	public static String getCususername() {
		return cususername;
	}
	public static void setCususername(String cususername) {
		Customer.cususername = cususername;
	}
	public static String getCuspassword() {
		return cuspassword;
	}
	public static void setCuspassword(String cuspassword) {
		Customer.cuspassword = cuspassword;
	}
	public static boolean isBiavailable() {
		return biavailable;
	}
	public static void setBiavailable(boolean biavailable) {
		Customer.biavailable = biavailable;
	}
	public static int getBioffer() {
		return bioffer;
	}
	public static void setBioffer(int bioffer) {
		Customer.bioffer = bioffer;
	}
	public static boolean isBiowned() {
		return biowned;
	}
	public static void setBiowned(boolean biowned) {
		Customer.biowned = biowned;
	}
	public static int getPaymentplan() {
		return paymentplan;
	}
	public static void setPaymentplan(int paymentplan) {
		Customer.paymentplan = paymentplan;
	}
	public static int getPaymentsremain() {
		return paymentsremain;
	}
	public static void setPaymentsremain(int paymentsremain) {
		Customer.paymentsremain = paymentsremain;
	}
	public static int getPaymentsmade() {
		return paymentsmade;
	}
	public static void setPaymentsmade(int paymentsmade) {
		Customer.paymentsmade = paymentsmade;
	}
	
	
	

	 
}