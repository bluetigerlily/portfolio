The Bicycle Shop app is a console-based application that facilitates the purchasing of bicycles. An employee can add bicycles to the inventory and manage offers for those bicycles, while a customer can view the available bicycles and make offers.


## Requirements
1. Functionality should reflect the below user stories.
2. Data is stored in a database.
3. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
4. All input is received using the java.util.Scanner class.
5. All public service layer methods must have at least one JUnit test.
6. Log4j is implemented to log events to a file.	


## User Stories


* As a user, I can login.

* As an employee, I can add a bicycle to the shop.

* As a customer, I can view the available bicycles.

* As a customer, I can make an offer for a bicycle.

* As an employee, I can accept or reject a pending offer for a bicycle.
	
* As the system, I update a bicycle to an owned state when an offer is accepted.
	
* As the system, I reject all other pending offers for a bicycle when an offer is accepted.
	
* As a user, I can register for a customer account.
	
* As an employee, I can remove a bicycle from the shop.
	
* As a customer, I can view the bicycles that I own.
	
* As a customer, I can view my remaining payments for a bicycle.
	
* As an employee, I can view all payments.
	
* As the system, I can calculate the weekly payment.


- As a user, I can make a payment.
- As a manager, I can make employee accounts.
- As an employee, I can edit existing bicycles.
- As a manager, I can fire employees.
- As a manager, I can view sales history of all offers.
