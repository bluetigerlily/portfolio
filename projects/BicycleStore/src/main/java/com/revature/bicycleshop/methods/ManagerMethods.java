package com.revature.bicycleshop.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.bicycleshop.connector.Connector;
import com.revature.bicycleshop.exceptions.NonUniqueUsernameException;
import com.revature.bicycleshop.interfaces.ManagerInterface;
import com.revature.bicycleshop.merchandise.Bicycles;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.users.Employee;
import com.revature.bicycleshop.users.Manager;

public class ManagerMethods implements ManagerInterface {

	
	
	Logger log = Logger.getLogger(ManagerMethods.class.getName());
	private Set<Employee> Employees;
	private Set<Manager> Managers;
	
	public	ManagerMethods() {
	
		Managers = new HashSet<>();
		Employees = new HashSet<>();
	}
	
	
	@Override
	public List<Customer> getSales(Integer bioffer) throws SQLException {
		// TODO Auto-generated method stub
		
String sqq ="SELECT * From bicyclestoreschema.'bicycles' WHERE bioffer =? ";
		
		
		List<Customer> getSalesList = new ArrayList<>();
		try (Connection connection = Connector.get_connection())
		{
			
			
			
			PreparedStatement preparedStatemnet = connection.prepareStatement(sqq);
			ResultSet rs = preparedStatemnet.executeQuery();
		while(rs.next())
		{
			Customer customer = new Customer();
			customer.setBioffer(rs.getInt("bioffer"));
			getSalesList.add(customer);
			
		}
		
		
		}
			return getSalesList;
		
	}

	@Override
	public void changeEmployStatus(boolean employstatus) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getMissedSales(Integer missedsales) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ManLoginName(String username) throws SQLException {
		
		String manusername  ="SELECT * From bicyclestoreschema.'manager' WHERE manusername =?";
		try (Connection connection = Connector.get_connection())
		{
			PreparedStatement pmpt = connection.prepareStatement(manusername);
			
			ResultSet rs = pmpt.executeQuery();
			
			while(rs.next());
			{
				Manager manager = new Manager();
				manager.setManusername(rs.getString("username"));
				return manusername;
		
		}
		}
	}
		

	@Override
	public String ManLoginPass(String password) throws SQLException {
		
		String manpassword  ="SELECT * From bicyclestoreschema.'manager' WHERE manpassword =?";
		try (Connection connection = Connector.get_connection())
		{
			PreparedStatement pmpt = connection.prepareStatement(manpassword);
			
			ResultSet rs = pmpt.executeQuery();
			
			while(rs.next());
			{
				Manager manager = new Manager();
				manager.setManpassword(rs.getString("password"));
				return manpassword;
		
		}
		}
	}

	@Override
	public Manager CreateEmployee(Employee input) throws NonUniqueUsernameException {
		String newemployee ="INSERT * From bicyclestoreschema.'employee' WHERE empusername =?";
		try (Connection connection = Connector.get_connection())
		{
			 PreparedStatement pmpt = connection.prepareStatement(newemployee);
					ResultSet rs = pmpt.executeQuery();
					
			for(Manager m : Managers) {	
		for (Employee e : Employees) {
			if (e.getEmpusername().equals(input.getEmpusername())) {
				throw new NonUniqueUsernameException();
			}
		
		}
			}
		input.setEmpid(Employees.size()+1);
		Employees.add(input); 
		} catch (SQLException ex){
			System.out.println(ex.getMessage());
			
		}
		
		return input;
}

}
