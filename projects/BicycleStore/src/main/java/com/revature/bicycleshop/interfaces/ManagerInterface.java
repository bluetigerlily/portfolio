package com.revature.bicycleshop.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.revature.bicycleshop.exceptions.NonUniqueUsernameException;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.users.Employee;
import com.revature.bicycleshop.users.Manager;

public interface ManagerInterface {
	
	List<Customer> getSales(Integer bioffer) throws SQLException;
	public Employee changeEmployStatus(Employee employee) throws SQLException;
	List<Customer> getMissedSales(Integer missedsales) throws SQLException;
	Employee CreateEmployee(Employee employee) throws NonUniqueUsernameException;
	public Manager ManLogin() throws Exception;
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
	

