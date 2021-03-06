package com.revature.bicycleshop.users;

public class Employee extends Manager {
	
	private static Integer empid;
	private static boolean bipending; 
	private static String empusername;
	private static String emppassword;
	private static boolean employstatus;
	private static boolean biavailable;
	private static String biname;
	private static Integer bimodel;
	
	
	
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
	
	public Employee(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public static boolean isBipending() {
		return bipending;
	}

	public static void setBipending(boolean bipending) {
		Employee.bipending = bipending;
	}

	public String getEmppassword() {
		return emppassword;
	}

	public void setEmppassword(String emppassword) {
		Employee.emppassword = emppassword;
	}

	public String getEmpusername() {
		return empusername;
	}

	public void setEmpusername(String empusername) {
		Employee.empusername = empusername;
	}

	public boolean isEmploystatus() {
		return employstatus;
	}

	public void setEmploystatus(boolean employstatus) {
		Employee.employstatus = employstatus;
	}
	public static Integer getEmpid() {
		return empid;
	}
	
	public void setEmpid(Integer empid) {
		Employee.empid = empid;
	}
	
	public void setBiavailable(boolean biavailable) {
		Employee.biavailable = biavailable;
	}
	
	public boolean isBiavailable() {
		return biavailable;
	}
	
	public void setBiname(String biname) {
		Employee.biname = biname;
	}
	
	public String getBiname() {
		return biname;
	}
	
	public void setBimodel(Integer bimodel) {
		Employee.bimodel = bimodel;
	}
	
	public Integer getBimodel() {
		return bimodel;
	}
	public Employee isEmploystatus(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	
