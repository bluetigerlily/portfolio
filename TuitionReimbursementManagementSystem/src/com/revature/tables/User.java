package com.revature.tables;

public class User {
	
	private static int userid;
	private static String username;
	private static String password;
	private static String firstname;
	private static String lastname;
	private static String useremail;
	private static int fundsavailable;
	private static int fundspending;
	private static String role;
	private static String events;
	
	
	public User(int userid, String username, String password, String firstname, String lastname, String useremail, int fundsavailable,
			int fundspending, String role, String events) {
		
		super();
		User.userid = userid;
		User.username = username;
		User.password = password;
		User.firstname = firstname;
		User.lastname = lastname;
		User.useremail = useremail;
		User.fundsavailable = fundsavailable;
		User.fundspending = fundspending;
		User.role = role;
		User.events = events;
		
		
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		User.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		User.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		User.password = password;
	}


	public static String getFirstname() {
		return firstname;
	}


	public static void setFirstname(String firstname) {
		User.firstname = firstname;
	}


	public static String getLastname() {
		return lastname;
	}


	public static void setLastname(String lastname) {
		User.lastname = lastname;
	}


	public static String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		User.useremail = useremail;
	}


	public static int getFundsavailable() {
		return fundsavailable;
	}


	public static void setFundsavailable(int fundsavailable) {
		User.fundsavailable = fundsavailable;
	}


	public static int getFundspending() {
		return fundspending;
	}


	public static void setFundspending(int fundspending) {
		User.fundspending = fundspending;
	}


	public static String getRole() {
		return role;
	}


	public static void setRole(String role) {
		User.role = role;
	}


	public static String getEvents() {
		return events;
	}


	public static void setEvents(String events) {
		User.events = events;
	}


	
	
	
	
	
	
	
	

}
