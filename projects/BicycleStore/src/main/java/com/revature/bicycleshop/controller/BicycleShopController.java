package com.revature.bicycleshop.controller;

import org.apache.log4j.Logger;
import com.revature.bicycleshop.exceptions.BiOfferAcceptedandBicycleOwnedException;
import com.revature.bicycleshop.exceptions.NonUniqueUsernameException;
import com.revature.bicycleshop.interfaces.CustomerInterface;
import com.revature.bicycleshop.interfaces.EmployeeInterface;
import com.revature.bicycleshop.interfaces.ManagerInterface;
import com.revature.bicycleshop.merchandise.Bicycles;
import com.revature.bicycleshop.methods.CustomerMethods;
import com.revature.bicycleshop.methods.EmployeeMethods;
import com.revature.bicycleshop.methods.ManagerMethods;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.users.Employee;
import com.revature.bicycleshop.users.Manager;
import com.revature.bicycleshop.users.User;
import java.util.Scanner;


public class BicycleShopController 
{

	private static Logger Log = Logger.getLogger(BicycleShopController.class.getName());
	private static CustomerInterface customerInterface = new CustomerMethods();
	private static EmployeeInterface emplopyeeInterface = new EmployeeMethods();
	private static ManagerInterface managerInterface = new ManagerMethods();
	private static Scanner scan;
	
	

	
	public static void main(String[]args) throws Exception {
		scan = new Scanner(System.in);
		boolean userActive = true;
		
		
		
		mainLoop: while (userActive) {
			System.out.println("Hello, Thank you for using Revature BicycleShop App!");
			
			User loggedinUser = null;
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
					customer.equals(loggedinUser);
					break;
				case "2":
					Log.info("Customer is logging in.");
					customer = CusLogin();
					customer.equals(loggedinUser);
					break;
				case "3":
					Log.info("Employee is logging in.");
					employee = EmpLogin();
					employee.equals(loggedinUser);
					break;
				case "4":
					Log.info("Manager is logging in.");
					manager = ManLogin();
					manager.equals(loggedinUser);
					break;
				default:
					Log.info("User is exiting the application.");
					userActive = false;
					break mainLoop;
				}
				
			  
			//login command using customername and customerpassword
			//view command to view biavailable by bimodel - available bicycles by the bicycle model type
			//offer command for bioffer using paymentplan to make an offer for an available bicycle under paymentplan
			//register command for making a new customername and customerpassword
			//view command to view biowned - owned bicycles
			//view command to view paymentsremain - weekly payments remaining would be (bioffer/paymentplan)-paymentsmade
		
		Bicycles bicycles = new Bicycles();
		Bicycles bicyclesold = new Bicycles();
		 
			menuLoop: while (true) {
			
				 
				if (("1".equals(userChoice))) {
					System.out.println("How can I help you today?");
					System.out.println("1. View our selection of Available Bicycles\n2. Make an offer on a Bicycle\n3. View your owned Bicycles \n4. View the number of weekly payments remaining on your payment plan \n5 Make a payment towards your remaining weekly remaining payments \nOther. Log Out");
						}
				
				if (("2".equals(userChoice))) {
				System.out.println("How can I help you today?");
				System.out.println("1. View our selection of Available Bicycles\n2. Make an offer on a Bicycle\n3. View your owned Bicycles \n4. View the number of weekly payments remaining on your payment plan \n5 Make a payment towards your remaining weekly remaining payments \nOther. Log Out");
				 }
				 		
						
				
				if (("3".equals(userChoice))) { 
				System.out.println("1. View our selection of Available Bicycles\n2. Make an offer on a Bicycle\n3. View your owned Bicycles \n4. View the number of weekly payments remaining on your payment plan \n5 Make a payment towards your remaining weekly remaining payments \n6. Add a bicycle to the shop \n7. Remove a bicycle from the shop \n8. View All payments for all Customers \n9.  View pending bike offers from customers awaiting approval \n10. Edit the existing bicycles in stock \nOther. Log Out");
					 }
					
					
				if (("4".equals(userChoice))) { 
				System.out.println("1. View our selection of Available Bicycles\n2. Make an offer on a Bicycle\n3. View your owned Bicycles \n4. View the number of weekly payments remaining on your payment plan \n5 Make a payment towards your remaining weekly remaining payments \n6. Add a bicycle to the shop \n7. Remove a bicycle from the shop \n8. View All payments for all Customers \n9.  View pending bike offers from customers awaiting approval \n10. Edit the existing bicycles in stock \n11. Make a new employee account \n12. View the sales History \n13. Fire an employee \n14. View missed potential sales \nOther. Log Out");
				 } 
					 
					 
			
			
				 
				
			
				String input = scan.nextLine();
				switch (input) {
				case "1":
					//view available bicycles
					customer = getAvailable(bicycles);
					break;
				case "2":
					//make an offer offer on available bicycles
					customer = MakeOffer(customer, bicycles);
					break;
				case "3":
					//view your owned bicycles
					customer = ViewOwned(customer);
					break;
				case "4":
					//view weekly payments remaining
					ViewPaymentsRemaining(customer);
					break;
				case "5":
					//make a payment towards remaining balance
					customer = MakeaPayment(customer);
					break;
				case "6":
					//add a bicycle to the shop
					employee = AddBi(bicycles);
					break;
				case "7":
					//remove a bicycle from the shop
					employee = RemoveBi(bicycles);
					break;
				case "8":
					//view all payments for all customers;
					ViewAllPayments(customer);
					break;
				case "9":
					//view pending bike offers awaiting approval
					  ViewPendingOffers();
					break;
				case "10":
					//edit the existing bicycles in stock
					EditExisting(bicycles, bicyclesold);
					break;
				case "11":
						//make a new employee account
					CreateEmployee(employee);
					break;
				case "12":
						//view the sales history
					manager = getSales(manager);
					break;
				case "13":
						//fire an employee
					changeEmployStatus(employee);
					break;
				case "14":
					 //view missed potential sales
					manager = getMissedSales(manager);
					break;
				default:
					if (loggedinUser == null) {
						System.out.println("Thank you for choosing Revature BicycleShop we hope to see you again!");
							Log.info("User logged out");
							break menuLoop;
							
					} 
					}
							    
				
			}	
				} 
			
			}
		scan.close();
			}   
					      
				
	 

		
	
			
			 
		

//was never one to begin with just ran out of time tbh
	private static Manager getMissedSales(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}


	private static Employee changeEmployStatus(Employee employee) throws Exception {
		
		while (true) {
			System.out.println("Press 1 if you would like to change the employment status of an employee");
			String input = (scan.nextLine());
			if (("1".equals(input))) {
				System.out.println("Please enter the employee's Employee Username");
				String empusername = (scan.nextLine());
				employee.setEmpusername(empusername);
				System.out.println("Please enter the employee's Employee Password");
				String emppassword = (scan.nextLine());
				employee.setEmppassword(emppassword);
				System.out.println("Please verify the employee's current employment status by typing true if currently employeed and false if unemployed");
				String employstatusstring = (scan.nextLine());
				if (("true".equals(employstatusstring))) {
					if (employstatusstring != null) {
						Boolean employstatus = Boolean.parseBoolean(employstatusstring);
						employee.setEmploystatus(employstatus);
					}
				if(("false".equals(employstatusstring))) {
					System.out.println("The employee "+empusername+" is already unemployed by the company would you like to rehire them? Please type yes or no");				
					String rehirestring = (scan.nextLine());
				
				if(("yes").equals(rehirestring)) {
					if (rehirestring != null) {
						rehirestring = "true";
						Boolean employstatus = Boolean.parseBoolean(rehirestring);
						employee.setEmploystatus(employstatus);
					}
				}
				}
				}
				if(managerInterface.changeEmployStatus(employee) == employee.isEmploystatus(true)) {
					System.out.println("The employee is still employed by the company");
					Log.debug(employee);
				}
				if(managerInterface.changeEmployStatus(employee) == employee.isEmploystatus(false)) {
					System.out.println("The employee is unemployed by the company");
					Log.debug(employee);
				}
				System.out.println("Press 1 to remove another or press anything else to return to the main menu have a wonderful day!");		 
					String input1 = scan.nextLine();
					if (!("1".equals(input1))) {
				return null;  
			
			}
			}
			
					
			return employee;
		
	}
	}
//ran out of time for this extra bonus one as well
	private static Manager getSales(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}


	private static Bicycles EditExisting(Bicycles bicycles, Bicycles bicyclesold) throws NonUniqueUsernameException {
		while (true) {
			

			System.out.println("Press 1 if you would like to edit an existing bicycles stored data");
			String input = (scan.nextLine());
			if (("1".equals(input))) {
			System.out.println("Please enter the bicycles exisiting Model Number: ");
			String modelnumber = (scan.nextLine());
			if(modelnumber != null) {
				Integer bimodelold = Integer.parseInt(modelnumber);
				bicyclesold.setBimodel(bimodelold);
			}	
			System.out.println("Please enter the bicycles new Model Number: ");
			String newmodelnumber = (scan.nextLine());
			if(newmodelnumber != null) {
				Integer bimodel = Integer.parseInt(newmodelnumber);
				bicycles.setBimodel(bimodel);
			}
			
			System.out.println("Please enter the bicycles old Name: ");
			String binameold = (scan.nextLine());
			if(binameold != null) {
			bicyclesold.setBiname(binameold);
			}
			System.out.println("Please enter the bicycles new Name: ");
			String newbiname = (scan.nextLine());
			if(newbiname != null) {
				bicycles.setBiname(newbiname);
			}
			System.out.println("Please enter if the bicycle availability originally : (true or false) ");
			String biavailablity = (scan.nextLine());
			if(biavailablity != null) {
				Boolean biavailableold = Boolean.parseBoolean(biavailablity);
				bicyclesold.setBiavailable(biavailableold);
			}
			System.out.println("Please enter the bicycles new availability: (true or false) ");
			String newbiavailablity = (scan.nextLine());
			if(newbiavailablity != null) {
				Boolean newbiavailable = Boolean.parseBoolean(newbiavailablity);
				bicycles.setBiavailable(newbiavailable);
			}
			if((emplopyeeInterface.EditExisting(bicycles, bicyclesold) == null))	{
				Log.debug("The users bicycles were not updated in the system something went wrong");  
			System.out.println("I'm sorry, your bicycles were not updated in our system please try again!");
			} else if(emplopyeeInterface.EditExisting(bicycles, bicyclesold) != null) {
				Log.debug("The bicycles were updated in the system");  
				System.out.println("Your bicycles were updated in the system Have a wonderful day!");
			}
			System.out.println("Press 1 to make changes to another employee's employment status or anything else to exit.  Have a wonderful day!");
			} else {
				}	String input1 = scan.nextLine();
					if (!("1".equals(input1))) {
				return bicycles; 
				
			}
		}
			 
		}
		

			


	private static void ViewPendingOffers() throws BiOfferAcceptedandBicycleOwnedException {

		while (true) {
			System.out.println("Press 1 to view all pending offers");
			String input = (scan.nextLine());
			if (("1".equals(input))) {
				emplopyeeInterface.ViewPendingOffers();
			}
			
		return;
		}
	}


	private static Customer ViewAllPayments(Customer customer) throws Exception {
		
while (true) {
			System.out.println("Press 1 to view all payments");
			String input = (scan.nextLine());
			if (("1".equals(input))) {
				System.out.println("Enter if the Customers username : ");
				String cususername = (scan.nextLine());
				if(!((null) == (cususername))){
					customer.setCususername(cususername);
				}
				System.out.println("Enter the customers offer: ");
				String offer =(scan.nextLine());
				if(!((null) == (offer))){
					Integer bioffer = Integer.parseInt(offer);
					customer.setBioffer(bioffer);
				}
				System.out.println("Enter the paymentplan: ");
				String paymentplans = (scan.nextLine());
				if(!((null) == (paymentplans))){
					int paymentplan = Integer.parseInt(paymentplans);
					customer.setPaymentplan(paymentplan);
				}				
				System.out.println("Enter the paymentsremaining: ");
				String paymentsremainings = (scan.nextLine());
				if(!((null) == (paymentsremainings))){
					int paymentsremain = Integer.parseInt(paymentsremainings);
					customer.setPaymentplan(paymentsremain);
				}	
				System.out.println("Enter the paymentsmade: ");
				String paymentsmades = (scan.nextLine());
				if(!((null) == (paymentsmades))){
					int paymentsmade = Integer.parseInt(paymentsmades);
					customer.setPaymentplan(paymentsmade);
				}
		if(emplopyeeInterface.ViewAllPayments(customer) != null)
		{
			Log.debug("The list of all the payments for the customer has been generated");  
		System.out.println("The list for all the payments for the customer has been generated, have a wonderful day!");
		
		} else if (emplopyeeInterface.ViewAllPayments(customer) == null ) {
			System.out.println("I'm sorry something went wrong when generating your list of payments in our System please try again!");
			Log.debug(customer);
			}
		System.out.println("Press 1 to make changes to another employee's employment status or anything else to exit.  Have a wonderful day!");
			} else {
				}	String input1 = scan.nextLine();
					if (!("1".equals(input1))) {
				return null;
			}
			return customer;
			}
	}

//should work needs testing
	private static Employee RemoveBi(Bicycles bicycles) throws Exception {
		
		while (true) {
			System.out.println("Enter if the bike was be available: true or false");
			String available = (scan.nextLine());
			if(!((null) == (available))){
				Boolean biavailable = Boolean.parseBoolean(available);
				bicycles.setBiavailable(biavailable);
			}
			System.out.println("Enter the bikes model number: ");
			String modelnum =(scan.nextLine());
			if(!((null) == (modelnum))){
				Integer bimodel = Integer.parseInt(modelnum);
				bicycles.setBimodel(bimodel);
			}
			System.out.println("Enter the bikes name: ");
			String bikename = (scan.nextLine());
			if(!((null) == (bikename))){
				bicycles.setBiname(bikename);
			}
			System.out.println("Press 1 to Remove the Bicycle to the List of Merchandise or press anything else to return to the main menu have a wonderful day!");
			String input = scan.nextLine();
			
			
			if (("1".equals(input))) {
				if(emplopyeeInterface.RemoveBi(bicycles) != null) { 
						Log.debug("The users bicycles were not removed from the system soomething went wrong");  }
						System.out.println("I'm sorry, your bicycles were not removed from the system please try again!");
					}	 else if (emplopyeeInterface.RemoveBi(bicycles) == null ) {
				System.out.println("Your bicycle has been removed from the system have a wonderful day!");
				Log.debug(bicycles);
				System.out.println("Press 1 to make changes to another employee's employment status or anything else to exit.  Have a wonderful day!");
						} else {
							}	String input1 = scan.nextLine();
								if (!("1".equals(input1))) {
							return null;  
										} } 
	}

//works 
	private static Employee AddBi(Bicycles bicycles) throws Exception {

		
		while (true) {
			System.out.println("Enter if the bike will be available: true or false");
			String available = (scan.nextLine());
			if(!((null) == (available))){
				Boolean biavailable = Boolean.parseBoolean(available);
				bicycles.setBiavailable(biavailable);
			}
			System.out.println("Enter the bikes model number: ");
			String modelnum =(scan.nextLine());
			if(!((null) == (modelnum))){
				Integer bimodel = Integer.parseInt(modelnum);
				bicycles.setBimodel(bimodel);
			}
			System.out.println("Enter the bikes name: ");
				
			bicycles.setBiname(scan.nextLine());
		
			System.out.println("Press 1 to Add the Bicycle to the List of Merchandise or press anything else to return to the main menu have a wonderful day!");
			String input = scan.nextLine();
			
			
			if (("1".equals(input))) {
				if(emplopyeeInterface.AddBi(bicycles) == null) { 
						Log.debug("The user entered no bicycles to input into the system");  }
						System.out.println("I'm sorry, you did not enter any bicycles to add to the system please try again");
					}	 else if (((null) != emplopyeeInterface.AddBi(bicycles))) {
				System.out.println("Your bicycle has been inputted into the system have a wonderful day!");
				Log.debug(bicycles);
				System.out.println("Press 1 to input another or press anything else to return to the main menu have a wonderful day!");
						} 	String input1 = scan.nextLine();
								if (!("1".equals(input1))) {
							return null;  
										} } 
	}


	private static Customer MakeaPayment(Customer customer) throws Exception {
		
		while (true) {
			
			System.out.println("Press 1 to make a payment on your bicycles");
			String input = (scan.nextLine());
			if (("1".equals(input))) {
				
				System.out.println("Please enter your username");
				customer.setCususername(scan.nextLine());
				System.out.println("Please enter your password");
				customer.setCuspassword(scan.nextLine());
				System.out.println("How many weeks of payments would you like to make today?");
				String weekspaid = scan.nextLine();
				System.out.println("How many weeks of payments did you have left to make today?");
				String paymentsremainstring = scan.nextLine();
				if(!((null) == (weekspaid))){
				int subtractionvalue = Integer.parseInt(weekspaid);
				customer.setPaymentsmade(subtractionvalue);
				int paymentsremain = Integer.parseInt(paymentsremainstring);
				int newpaymentsremain = paymentsremain - subtractionvalue;
					customer.setPaymentsremain(newpaymentsremain);
				if(customerInterface.MakeaPayment(customer) == null)
				{
					Log.debug("The user has no payments remaining");
					System.out.println("You no longer have remaining payments due have a wonderful day");
				 if (customerInterface.MakeaPayment(customer) != null) {
					 Log.debug("The user has payments remaining");
						System.out.println("You have remaining payments due have a wonderful day");
					}
				}
				System.out.println("Press 1 to input another or press anything else to return to the main menu have a wonderful day!");
				String input1 = scan.nextLine();
					if (!("1".equals(input1))) {  		 
						return customer;
				
		
			
		}
		}
		
		return null;
	}
	}
	}

	private static int ViewPaymentsRemaining(Customer customer) throws Exception {

		while (true) {
			int value = 0;
			System.out.println("Press 1 to view your remaining payments");
			String input = (scan.nextLine());
			if (("1".equals(input))) {
				if(customerInterface.ViewPaymentsRemaining(customer) == 0) { 
						Log.debug("The user has no payments remaining");  }
						System.out.println("I'm sorry, you dont have any payments remaining have a wonderful day");
					}	 else if (customerInterface.ViewPaymentsRemaining(customer) != 0) {
						Log.debug("The user has outstanding payments remaining");  
			System.out.println("You seem to have some weekly payments remaining have a wonderful day");
					}
			System.out.println("Press 1 to input another or press anything else to return to the main menu have a wonderful day!");
			String input1 = scan.nextLine();
				if (!("1".equals(input1))) {  		 
					return value;
			
				}
		
	}
	}
	
	
//need to add joins on the biowns the customer data columns and the merchandise in the bicycle tables for this one to work as intended
	
	private static Customer ViewOwned(Customer customer) throws Exception {
		
		
		
		while (true) {
			
		
		System.out.println("Please, enter your username");
		String username = (scan.nextLine());
		if(!((null) == (username))){
			customer.setCususername(username);
		}
		System.out.println("Please, enter your password");
		String password = (scan.nextLine());
		if(!((null) == (password))){
			customer.setCususername(password);
		}
		System.out.println("Do you own a bicycle?");
		String input = (scan.nextLine());
		if(!((input) == ("no"))){
			
			if(customerInterface.ViewOwned(customer).equals(null)) { 
				Log.debug("Something went wrong with generating the owned bicycles ");  }
				System.out.println("I'm sorry, something went wrong with generating your list of owned bicycles please try again");
			}	 else if (customerInterface.ViewOwned(customer) != null) {
		Log.debug("Your list of owned bicycles has been generated successfully have a wonderful day!");
		Log.debug(customer);
		System.out.println("Press 1 to input another or press anything else to return to the main menu have a wonderful day!");
				} else {
					}	String input1 = scan.nextLine();
						if (!("1".equals(input1))) {
					return customer;  
								}} }

//need to add the joining with the bicycles part of the make offer for it to fully function as expected
	private static Customer MakeOffer(Customer customer, Bicycles bicycles) throws Exception {
		
		
		while (true) {
			System.out.println("Please, enter your username");
			String username = (scan.nextLine());
			if(!((null) == (username))){
				customer.setCususername(username);
			}
			System.out.println("Please, enter your password");
			String password = (scan.nextLine());
			if(!((null) == (password))){
				customer.setCususername(password);
			}
			System.out.println("Please, enter the amount you'd be comfortable paying on your selected bicycle");
			String paymentoffer = (scan.nextLine());
			if(!((null) == (paymentoffer))){
				Integer bioffer = Integer.parseInt(paymentoffer);
				customer.setBioffer(bioffer);
			}
			System.out.println("Please enter the number amount of weeks it'd take you to pay that full amount of your above offer");
			String paymentplanstring = (scan.nextLine());
			if(!((null) == (paymentplanstring))){
				Integer paymentplan = Integer.parseInt(paymentplanstring);
				customer.setPaymentplan(paymentplan);
			}
			System.out.println("Enter the bikes name: ");
			String bikename = (scan.nextLine());
			if(!((null) == (bikename))){
				bicycles.setBiname(bikename);
			}
			System.out.println("Enter the bikes model number: ");
			String bikemodel = (scan.nextLine());
			if(!((null) == (bikemodel))){
				Integer bimodel = Integer.parseInt(bikemodel);
				bicycles.setBimodel(bimodel);
			}
			System.out.println("Enter if the bike is available: true or false ");
			String available = (scan.nextLine());
			if(!((null) == (available))){
				Boolean biavailable = Boolean.parseBoolean(available);
				bicycles.isBiavailable(biavailable);
			}
			System.out.println("Press 1 to Make the offer on the Bicycle or press anything else to return to the main menu have a wonderful day!");
			String input = scan.nextLine();
			
			
			if (("1".equals(input))) {
				if(customerInterface.MakeOffer(customer, bicycles) == null) { 
						Log.debug("Something went wrong with the inputting of the bicycle offer ");  }
						System.out.println("I'm sorry, something went wrong with your offer please try again");
					}	 else if (customerInterface.MakeOffer(customer, bicycles) != null) {
				Log.debug("Your bicycle has been inputted into the system have a wonderful day!");
				Log.debug(bicycles);
				System.out.println("Press 1 to input another or press anything else to return to the main menu have a wonderful day!");
						} else {
							}	String input1 = scan.nextLine();
								if (!("1".equals(input1))) {
							return customer;  
										} } 
	}

//might work might not needs testing and tweaking
	private static Customer getAvailable(Bicycles bicycles) throws Exception {
		
		
		while (true) {
			System.out.println("Press 1 to View the Available List of Bicycles or press anything else to return to the main menu have a wonderful day!");
			String input = scan.nextLine();
			if (("1".equals(input))) {
				if(customerInterface.getAvailable(bicycles) == null) { 
						Log.debug("There were no Bicycles available at this Time.");  }
						System.out.println("I'm sorry there are no available Bicycles available at this time Please try again later.");
					}	 else if (customerInterface.getAvailable(bicycles) != null) {
				Log.debug("List was generated of the available bicycles successfully");
				Log.debug(bicycles);
				System.out.println("Press 1 to generate the list again or press anything else to return to the main menu have a wonderful day!");
						return null;
						} else {
						}	String input1 = scan.nextLine(); 
						if (!("1".equals(input1))) {
							return null;  
										} } }
//works
	private static Manager ManLogin() throws Exception {
				Manager manager = new Manager();
		
		while (true) {
			System.out.println("Enter username: ");
			manager.setManusername(scan.nextLine());
			System.out.println("Please Enter Your Password: ");
			manager.setManpassword(scan.nextLine());
			String password = manager.getManpassword();
			manager = managerInterface.ManLogin();
			if (manager == null) {
				Log.debug("Manager entered a username that doesn't exist.");
				System.out.println("I'm sorry the Username you entered does not exist please try again.");
			} else if (manager.getManpassword().equals(password)) {
				Log.debug("Manager logged in successfully.");
				Log.debug(manager);
				System.out.println("Welcome back!");
				return manager;
			} else {
				Log.debug("User entered an incorrect password.");
				System.out.println("I'm sorry that password is incorrect.");
			}
			System.out.println("Press 1 to try again or press anything else to return to the main menu have a wonderful day!");
			String input = scan.nextLine();
			if (!("1".equals(input)))
		
				return null;
		}
	}

//works
	private static Employee EmpLogin() throws Exception {
		Employee employee = new Employee();
		
		while (true) {
			System.out.println("Enter username: ");
			employee.setEmpusername(scan.nextLine());
			System.out.println("Please Enter Your Password: ");
			employee.setEmppassword(scan.nextLine());
			String password = employee.getEmppassword();
			employee = emplopyeeInterface.EmpLogin();
			if (employee == null) {
				Log.debug("Employee entered a username that doesn't exist.");
				System.out.println("I'm sorry the Username you entered does not exist please try again.");
			} else if (employee.getEmppassword().equals(password)) {
				Log.debug("Employee logged in successfully.");
				Log.debug(employee);
				System.out.println("Welcome back!");
				return employee;
			} else {
				Log.debug("User entered an incorrect password.");
				System.out.println("I'm sorry that password is incorrect.");
			}
			System.out.println("Press 1 to try again or press anything else to return to the main menu have a wonderful day!");
			String input = scan.nextLine();
			if (!("1".equals(input)))
		
				return null;
		}
	}

//works
		private static Customer CusLogin() throws Exception {
				Customer customer = new Customer();
				
		while (true) {
			System.out.println("Enter username: ");
			customer.setCususername(scan.nextLine());
			System.out.println("Please Enter Your Password: ");
			customer.setCuspassword(scan.nextLine());
			String password = customer.getCuspassword();
			customer = customerInterface.CusLogin();
			if (customer == null) {
				Log.debug("Customer entered a username that doesn't exist.");
				System.out.println("I'm sorry the Username you entered does not exist please try again.");
			} else if (customer.getCuspassword().equals(password)) {
				Log.debug("Customer logged in successfully.");
				Log.debug(customer);
				System.out.println("Welcome back!");
				return customer;
			} else {
				Log.debug("User entered an incorrect password.");
				System.out.println("I'm sorry that password is incorrect.");
			}
			System.out.println("Press 1 to try again or press anything else to return to the main menu have a wonderful day!");
			String input = scan.nextLine();
			if (!("1".equals(input)))
		
				return null;
		}
	}
	
		


//works
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
			System.out.println("1 to confirm, 2 to try again, other to cancel");
			String input = scan.nextLine();  
			switch (input) {
			case "1":
				Log.debug("Submitting new Customer Information to the database...");
				try {
					customer.setCustomer(customerInterface.CreateCustomer(customer));
					Log.debug(customer);
					System.out.println("Confirmed. Welcome to the Revature BicycleShop.");
					return customer;
				} catch (Exception e) {
					System.out.println("Sorry, that name is already taken. Please try again!");
					Log.warn("User tried to register with a non-unique name.");
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
	//this is manager creating an  employee account dont be confused by variable labeling look at interface layer
	private static Employee CreateEmployee(Employee employee) throws NonUniqueUsernameException {
		while (true) {
			System.out.println("Enter a username: ");
			employee.setEmpusername(scan.nextLine());
			System.out.println("Enter a password: ");
			employee.setEmppassword(scan.nextLine());	
			System.out.println("Does this look good?");
			System.out.println("Username: " + employee.getEmpusername() + 
					" Password: " + employee.getEmppassword());
			System.out.println("1 to confirm, 2 to start over, other to cancel");
			String input = scan.nextLine();  
			switch (input) {
			case "1":
				Log.debug("Submitting new Employee Information to the database...");
				try {
					employee.setEmployee(managerInterface.CreateEmployee(employee));
					Log.debug(employee);
					System.out.println("Confirmed the submission of the new employee user Welcome to the Revature BicycleShop Family!");
					return employee;
				} catch (NonUniqueUsernameException e) {
					System.out.println("Sorry, that name is already taken. Please try again!");
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

	
	
	
	
