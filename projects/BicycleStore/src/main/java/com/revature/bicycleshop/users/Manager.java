package com.revature.bicycleshop.users;


public class Manager extends User{
	
	
	
	private static Integer manid;
	private static String manusername;
	private static String manpassword;
	private static Integer sales;
	private static Integer missedsales;
	@SuppressWarnings("unused")
	private static String empusername;
	@SuppressWarnings("unused")
	private static String emppassword;
	private static Integer empid;
	
	
	
	//getters and setters
	
	
	public Manager(Integer manid, String manusername, String manpassword, Integer sales, Integer missedsales, String empusername, String emppassword, Integer empid)
	{
		super();
		Manager.setManid(manid);
		Manager.manusername = manusername;
		Manager.manpassword = manpassword;
		Manager.sales = sales;
		Manager.missedsales = missedsales;
		Manager.emppassword = emppassword;
		Manager.empusername = empusername;
		Manager.empid = empid;
	}
	
	
	public Manager() {
		
	}
	
	

	public String getManpassword() {
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

	
	

	public void setEmployee(Employee CreateEmployee) {
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

	public void setEmpusername(String empusername) {
		Manager.empusername = empusername;
	}
	public void setEmppassword(String emppassword) {
		Manager.emppassword = emppassword;
	}

	public static Integer getEmpid() {
		return empid;
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