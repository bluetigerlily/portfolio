package com.revature.bicycleshop.interfaces;

import java.sql.SQLException;
import java.util.List;
import com.revature.bicycleshop.merchandise.Bicycles;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.users.Employee;

//
//private static String cususername;
//private static String cuspassword;
//private static boolean biavailable;
//private static int bioffer;
//private static boolean biowned;
//public static int bimodel;
//private static int paymentplan;
//private static int paymentsmade;
//private static int paymentsremain;
//public static int date;
//private static boolean bipending;
//private static String empusername;
//private static String emppassword;
//private static boolean employstatus;

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


public interface EmployeeInterface {

	public String EmpLoginName(String username) throws SQLException;
	public String EmpLoginPass(String password) throws SQLException;
	public void CreateCustomerEmpname(String empusername) throws SQLException;
	public void CreateCustomerEmpPass(String emppassword) throws SQLException;
	public void AddBiavailable(boolean biavailable) throws SQLException;
	public void AddBi(List<Employee> List) throws SQLException;
	public void RemoveBi(List<Employee> List) throws SQLException;
	public List<Customer> ViewAllPayments(Integer paymentsmade) throws SQLException;
	public List<Customer> ViewPending(Integer bioffer) throws SQLException;
	public void EditExistingBimodel(Integer bimodel) throws SQLException;
	public void EditExistingBiavailable(boolean biavailable) throws SQLException;
	public void EditExistingBiavailable(String biname) throws SQLException;
}
