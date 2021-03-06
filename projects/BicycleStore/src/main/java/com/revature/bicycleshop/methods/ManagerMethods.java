package com.revature.bicycleshop.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import org.apache.log4j.Logger;
import com.revature.bicycleshop.connector.Connector;
import com.revature.bicycleshop.exceptions.NonUniqueUsernameException;
import com.revature.bicycleshop.interfaces.ManagerInterface;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.users.Employee;
import com.revature.bicycleshop.users.Manager;

public class ManagerMethods implements ManagerInterface {

	
	private Connector conn = Connector.getConnector();
	Logger log = Logger.getLogger(ManagerMethods.class.getName());
	
	
	
	
	
	public	ManagerMethods() {
	
		new HashSet<>();
		new HashSet<>();
	}
	
	


	@Override
	public Employee changeEmployStatus(Employee employee) throws SQLException {
		
		try (Connection con = conn.getConnection()){

			con.setAutoCommit(false);
			String sql  ="UPDATE FROM employee (empusername, emppassword, employstatus) VALUES(?, ?, ?)";
			PreparedStatement pmpt = con.prepareStatement(sql);
			pmpt.setString(1, employee.getEmpusername());
			pmpt.setString(2, employee.getEmppassword());
			pmpt.setBoolean(2, employee.isEmploystatus());
			pmpt.executeUpdate();
				
					con.commit();
		}
				catch (SQLException e) {
					throw new SQLException();
				}
		return employee;
	}
		
			
	

	@Override
	public List<Customer> getMissedSales(Integer missedsales) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

		
	@Override
	public Manager ManLogin() throws Exception {
		Manager manager = new Manager();
	try (Connection con = conn.getConnection()){

		con.setAutoCommit(false);
		String sql  ="SELECT FROM manager (manusername, manpassword) VALUES(?, ?)";
		PreparedStatement pmpt = con.prepareStatement(sql);
		
		pmpt.setString(1, manager.getManusername());
		pmpt.setString(2, manager.getManpassword());
		pmpt.executeQuery();
		 } catch (Exception e) {
				if (e.getMessage().contains("violates unique constraint")) {
					throw new NonUniqueUsernameException();
			}     
	}
	return manager;
}




	@Override
	public List<Customer> getSales(Integer bioffer) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Employee CreateEmployee(Employee employee) throws NonUniqueUsernameException {
		
		
		try (Connection con = conn.getConnection()){
			con.setAutoCommit(false);
			String sql ="INSERT INTO employee  VALUES(default, ?, ?)";
			String[] keys = {"empid"};
			PreparedStatement pmpt = con.prepareStatement(sql, keys);
			pmpt.setString(1, employee.getEmpusername());
			pmpt.setString(2, employee.getEmppassword());
			pmpt.executeUpdate();
			ResultSet rs = pmpt.getGeneratedKeys();
			
			while (rs.next()) {
				 Employee empy = new Employee();
				empy.setEmpid(rs.getInt(1));
				con.commit(); 
				if(empy.equals(null)) {
					con.rollback(); } } 
		} catch (Exception e ) {
			if (e.getMessage().contains("violates unique constraint")) {
				throw new NonUniqueUsernameException();
			}
		} 
		
		
		
		return employee;
	}
	
	}
	