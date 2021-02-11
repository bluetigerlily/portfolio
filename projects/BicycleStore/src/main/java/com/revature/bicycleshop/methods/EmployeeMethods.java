package com.revature.bicycleshop.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

import org.apache.log4j.Logger;

import com.revature.bicycleshop.connector.Connector;
import com.revature.bicycleshop.interfaces.EmployeeInterface;
import com.revature.bicycleshop.merchandise.Bicycles;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.users.Employee;

public class EmployeeMethods<bicycles> implements EmployeeInterface {

	
	Logger log = Logger.getLogger(EmployeeMethods.class.getName());
	

	

	@Override
	public void AddBi(List<Employee> List) throws SQLException {
	
		
		String sii ="INSERT * From bicyclestoreschema. INTO 'employee'(bimodel) "
				+ "VALUES(?)";
		
		
		
		
		try (Connection connection = Connector.get_connection())
		{	
				
			
		PreparedStatement preparedStatemnet = connection.prepareStatement(sii);
		ResultSet rs = preparedStatemnet.executeQuery();
			for(Employee employee: List) 
			
			{
			Scanner ss = new Scanner(System.in);
		
				
				String s = ss.nextLine(); 
				
				System.out.println("Please Enter the model number of the bike you would like to add to the system");
				preparedStatemnet.setString(1, s);
				
				
					
			
						
			
			}
		
		
	}catch (SQLException ex)
		{
		System.out.println(ex.getMessage());
		}
	
	

}


	@Override
	public List<Customer> ViewAllPayments(Integer paymentsmade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> ViewPending(Integer bioffer) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String EmpLoginPass(String password) throws SQLException {
		String emppassword  ="SELECT * From bicyclestoreschema.'employee' WHERE empusername =?";
		try (Connection connection = Connector.get_connection())
		{
			PreparedStatement pmpt = connection.prepareStatement(emppassword);
			
			ResultSet rs = pmpt.executeQuery();
			
			while(rs.next());
			{
				Employee.setEmppassword(rs.getString("password"));
				return emppassword;
		
		}
}
	}

	@Override
	public void CreateCustomerEmpname(String empusername) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CreateCustomerEmpPass(String emppassword) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddBiavailable(boolean biavailable) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EditExistingBimodel(Integer bimodel) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EditExistingBiavailable(boolean biavailable) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EditExistingBiavailable(String biname) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String EmpLoginName(String username) throws SQLException {
		
		String empusername  ="SELECT * From bicyclestoreschema.'employee' WHERE empusername =?";
		try (Connection connection = Connector.get_connection())
		{
			PreparedStatement pmpt = connection.prepareStatement(empusername);
			
			ResultSet rs = pmpt.executeQuery();
			
			while(rs.next());
			{
				Employee.setEmpusername(rs.getString("username"));
				return empusername;
		
		}
}
	}

	@Override
	public void RemoveBi(List<Employee> List) throws SQLException {
		// TODO Auto-generated method stub
		
	}


}