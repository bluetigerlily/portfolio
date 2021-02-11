package com.revature.bicycleshop.controller;

import org.apache.log4j.Logger;
import com.revature.bicycleshop.*;
import com.revature.bicycleshop.exceptions.NonUniqueUsernameException;
import com.revature.bicycleshop.interfaces.CustomerInterface;
import com.revature.bicycleshop.interfaces.EmployeeInterface;
import com.revature.bicycleshop.interfaces.ManagerInterface;
import com.revature.bicycleshop.methods.CustomerMethods;
import com.revature.bicycleshop.methods.EmployeeMethods;
import com.revature.bicycleshop.methods.ManagerMethods;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.users.Employee;
import com.revature.bicycleshop.users.Manager;
import com.revature.bicycleshop.users.Users;

import java.sql.SQLException;
import java.util.Scanner;


public class BicycleShopController 
{

	private static Logger Log = Logger.getLogger(BicycleShopController.class.getName());
	private static CustomerInterface customerInterface = new CustomerMethods();
	private static EmployeeInterface emplopyeeInterface = new EmployeeMethods();
	private static ManagerInterface managerInterface = new ManagerMethods();
	private static Scanner scan;
	
	
	public static void main(String[]args) {
		scan = new Scanner(System.in);
		boolean userActive = true;
		
		mainLoop: while (userActive) {
			System.out.println("Hello, Thank you for using Revature BicycleShop App!");
			
		//Customer gotta make a new layer for each
			//Employee
			//Manager
			Users loggedinUser = null;
			
			Customer customer = new Customer();
			Employee employee = new Employee();
			Manager manager = new Manager();
			
			while (loggedinUser == null) {
				System.out.println("What would you like to do?");
				System.out.println("1. Register\n" 
								+ "2. Customer Log in\n3. Employee Log in\n4. Manager Log in\n"
								+ "Other. Exit");
				String userChoice = scan.nextLine();
				
				switch (userChoice) {
				case "1":
					Log.info("User is registering an account.");
					customer = CreateCustomer();
					break;
				case "2":
					Log.info("Customer is logging in.");
					userChoice = CusLogin();
					break;
				case "3":
					Log.info("Employee is logging in.");
					userChoice = EmpLogin();
					break;
				case "4":
					Log.info("Manager is logging in.");
					userChoice = ManLogin();
					break;
				default:
					Log.info("User is exiting the application.");
					userActive = false;
					break mainLoop;
				}
			}
			//login command using customername and customerpassword
			//view command to view biavailable by bimodel - available bicycles by the bicycle model type
			//offer command for bioffer using paymentplan to make an offer for an available bicycle under paymentplan
			//register command for making a new customername and customerpassword
			//view command to view biowned - owned bicycles
			//view command to view paymentsremain - weekly payments remaining would be (bioffer/paymentplan)-paymentsmade
			menuLoop: while (true) {
				System.out.println("How can I help you today?");
				System.out.println("1. View our selection of Available Bicycles\n2. Make an offer on a Bicycle\n3. View your owned Bicycles \n4. View the number of weekly payments remaining on your payment plan \n5 Make a payment towards your remaining weekly remaining payments \nOther. Log Out");
				if ("Customer".equals(customer.getCususername())) 
					
					System.out.println("Other. Log out");
						
				else if ("Employee".equals(employee.getEmpusername()))
						
					System.out.println("6. Add a bicycle to the shop \n7. Remove a bicycle from the shop \n8. View All payments for all Customers \n9.  View pending bike offers from customers awaiting approval \n10. Edit the existing bicycles in stock \nOther. Log Out");
				
				else if ("Manager".equals(manager.getManusername()))
						
						System.out.println("11. Make a new employee account \n12. View the sales History \n13. Fire an employee \n14. View missed potential sales \nOther Log Out");
				
	
				String input = scan.nextLine();
				switch (input) {
				case "1":
					//view available bicycles
					customer = getAvailable(customer);
					break;
				case "2":
					//make an offer offer on available bicycles
					customer = MakeOffer(customer);
					break;
				case "3":
					//view your owned bicycles
					customer = ViewOwned(customer);
					break;
				case "4":
					//view weekly payments remaining
					customer = ViewPaymentsRemaining(customer);
					break;
				case "5":
					//make a payment towards remaining balance
					customer = MakeaPayment(customer);
					break;
				case "6":
					//add a bicycle to the shop
					employee = AddBi(employee);
					break;
				case "7":
					//remove a bicycle from the shop
					employee = RemoveBi(employee);
					break;
				case "8":
					//view all payments for all customers;
					employee = ViewAllPayments(employee);
					break;
				case "9":
					//view pending bike offers awaiting approval
					employee = ViewPending(employee);
					break;
				case "10":
					//edit the existing bicycles in stock
					employee = EditExisting(employee);
					break;
				case "11":
						//make a new employee account
					manager = CreateEmployee(manager);
					break;
				case "12":
						//view the sales history
					manager = getSales(manager);
					break;
				case "13":
						//fire an employee
					manager = changeEmployStatus(manager);
					break;
				case "14":
					 //view missed potential sales
					manager = getMissedSales(manager);
					break;
				default: Log.info("User is exiting the application");
				userActive = false;
				break mainLoop;
				
				}
			}
			
			
		}
	}


	private static String ManLogin() throws SQLException {
		
		while (true) {
			System.out.println("Enter username: ");
			String username = scan.nextLine();
			System.out.println("Enter password: ");
			String password = scan.nextLine();
			
			String Manager = managerInterface.ManLoginName(username);
			if (Manager == null) {
				Log.debug("User entered a username that doesn't exist.");
				System.out.println("Nobody exists with that username.");
			} else if (Users.getManpassword().equals(password)) {
				Log.debug("Customer logged in successfully.");
				Log.debug(Manager);
				System.out.println("Welcome back!");
				return Manager;
			} else {
				Log.debug("User entered an incorrect password.");
				System.out.println("That password is incorrect.");
			}
			System.out.println("Do you want to try again? 1 for yes, other for no.");
			String input = scan.nextLine();
			if (!("1".equals(input)))
		
		
		return null;
	}
	}

	private static String EmpLogin() throws SQLException {
	
		while (true) {
					System.out.println("Enter username: ");
					String username = scan.nextLine();
					System.out.println("Enter password: ");
					String password = scan.nextLine();
					
					String Employee = emplopyeeInterface.EmpLoginName(username);
					if (Employee == null) {
						Log.debug("Employee entered a username that doesn't exist.");
						System.out.println("Nobody exists with that username.");
					} else if (Users.getEmppassword().equals(password)) {
						Log.debug("Employee logged in successfully.");
						Log.debug(Employee);
						System.out.println("Welcome back!"+username);
						return Employee;
					} else {
						Log.debug("User entered an incorrect password.");
						System.out.println("That password is incorrect.");
					}
					System.out.println("Do you want to try again? 1 for yes, other for no.");
					String input = scan.nextLine();
					if (!("1".equals(input)))
				
				
				return null;
}
		
	}

	private static String CusLogin() throws SQLException {
		
		while (true) {
			System.out.println("Enter username: ");
			String username = scan.nextLine();
			System.out.println("Enter password: ");
			String password = scan.nextLine();
			
			String Customer = customerInterface.CusLoginName(username);
			if (Customer == null) {
				Log.debug("User entered a username that doesn't exist.");
				System.out.println("Nobody exists with that username.");
			} else if (Users.getCuspassword().equals(password)) {
				Log.debug("Customer logged in successfully.");
				Log.debug(Customer);
				System.out.println("Welcome back!");
				return Customer;
			} else {
				Log.debug("User entered an incorrect password.");
				System.out.println("That password is incorrect.");
			}
			System.out.println("Do you want to try again? 1 for yes, other for no.");
			String input = scan.nextLine();
			if (!("1".equals(input)))
		
				return null;
		}
	}
	
		



	private static Customer CreateCustomer() {
		while (true) {
			Customer customer = new Customer();
			System.out.println("Enter a username: ");
			customer.setCususername(scan.nextLine());
			System.out.println("Enter a password: ");
			customer.setCuspassword(scan.nextLine());	
			System.out.println("Does this look good?");
			System.out.println("Username: " + customer.getCususername() + 
					" Password: " + customer.getCuspassword());
			System.out.println("1 to confirm, 2 to start over, other to cancel");
			String input = scan.nextLine();  
			switch (input) {
			case "1":
				Log.debug("Submitting new Customer Information to the database...");
				try {
					customer.setCustomer(customerInterface.CreateCustomer(customer));
					Log.debug(customer);
					System.out.println("Confirmed. Welcome to the Revature BicycleShop.");
					return customer;
				} catch (NonUniqueUsernameException e) {
					System.out.println("Sorry, that username is taken. Try again!");
					Log.warn("User tried to register with a non-unique username.");
				}
				break;
			case "2":
				System.out.println("Okay, let's try again.");
				break;
			default:
				System.out.println("Okay, let's go back.");
				return null;
			}
		}

	}
	
	private static Manager CreateEmployee() {
		while (true) {
			Employee employee = new Employee();
			Manager manager = new Manager();
			System.out.println("Enter a username: ");
			manager.setEmpusername(scan.nextLine());
			System.out.println("Enter a password: ");
			manager.setEmppassword(scan.nextLine());	
			System.out.println("Does this look good?");
			System.out.println("Username: " + manager.getEmpusername() + 
					" Password: " + manager.getEmppassword());
			System.out.println("1 to confirm, 2 to start over, other to cancel");
			String input = scan.nextLine();  
			switch (input) {
			case "1":
				Log.debug("Submitting new Employee Information to the database...");
				try {
					manager.setEmployee(managerInterface.CreateEmployee(employee));
					Log.debug(manager);
					System.out.println("Confirmed. Welcome to the Revature BicycleShop.");
					return employee;
				} catch (NonUniqueUsernameException e) {
					System.out.println("Sorry, that username is taken. Try again!");
					Log.warn("User tried to register with a non-unique username.");
				}
				break;
			case "2":
				System.out.println("Okay, let's try again.");
				break;
			default:
				System.out.println("Okay, let's go back.");
				return null;
			}
		}

	}
	
	
	
}
	
	
	//ask for username from user and run scanner input command
		//ask for password from user and run scanner input command
		
		/*if password correct return login successful then proceed according to case
		  if password or username wrong return login unsuccessful rerun cruddisplaylogin and 
		 and display message that login was unsuccessful due to incorrect username or password 
		 */
		
		
		
		//case 1: if employee logins do... run crud display for employee from cruddisplayswitch
		//case 2: if customer logins do...  run crud display for customer from cruddisplayswitch
		//case 3: if management logins do... run crud display for management from cruddisplayswitch
	
	