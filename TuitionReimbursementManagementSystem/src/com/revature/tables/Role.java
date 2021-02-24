package com.revature.tables;

public class Role {

private static String employee;
private static String directsuperemp;
private static String directsuperbenco;
private static String departmenthead;
private static String benco;
private static String role;




	public Role(String employee, String directsuperemp, String directsuperbenco, String departmenthead,
			String benco, String role) {
		
		super();
		Role.employee = employee;
		Role.directsuperemp = directsuperemp;
		Role.directsuperbenco = directsuperbenco;
		Role.departmenthead = departmenthead;
		Role.benco = benco;
		Role.role = role;
		
	}



	public static String getEmployee() {
		return employee;
	}



	public static void setEmployee(String employee) {
		Role.employee = employee;
	}



	public static String getDirectsuperemp() {
		return directsuperemp;
	}



	public static void setDirectsuperemp(String directsuperemp) {
		Role.directsuperemp = directsuperemp;
	}



	public static String getDirectsuperbenco() {
		return directsuperbenco;
	}



	public static void setDirectsuperbenco(String directsuperbenco) {
		Role.directsuperbenco = directsuperbenco;
	}



	public static String getDepartmenthead() {
		return departmenthead;
	}



	public static void setDepartmenthead(String departmenthead) {
		Role.departmenthead = departmenthead;
	}



	public static String getBenco() {
		return benco;
	}



	public static void setBenco(String benco) {
		Role.benco = benco;
	}



	public static String getRole() {
		return role;
	}



	public static void setRole(String role) {
		Role.role = role;
	}
	
	
}
