package com.revature.bicycleshop.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.revature.bicycleshop.connector.Connector;
import com.revature.bicycleshop.exceptions.BiOfferAcceptedandBicycleOwnedException;
import com.revature.bicycleshop.exceptions.NonUniqueUsernameException;
import com.revature.bicycleshop.interfaces.EmployeeInterface;
import com.revature.bicycleshop.merchandise.Bicycles;
import com.revature.bicycleshop.users.Customer;
import com.revature.bicycleshop.users.Employee;

public class EmployeeMethods implements EmployeeInterface {

	private Connector conn = Connector.getConnector();
	Logger log = Logger.getLogger(EmployeeMethods.class.getName());
	



	@Override //working on still
	public Customer ViewAllPayments(Customer customer) throws Exception {
		
		try (Connection con = conn.getConnection()){
			con.setAutoCommit(false);	
		String sql  ="SELECT FROM customer WHERE (cususername, bioffer, paymentplan, paymentsmade, paymentsremain) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pmpt = con.prepareStatement(sql);
		pmpt.setString(1, customer.getCususername());
		pmpt.setInt(2, customer.getBioffer());
		pmpt.setInt(3, customer.getPaymentplan());
		pmpt.setInt(4, customer.getPaymentsmade());
		pmpt.setInt(5, customer.getPaymentsremain());
		
		ResultSet rs = pmpt.executeQuery();
		while (rs.next()) {
			String cususername = rs.getString("cususername");
					int bioffer = rs.getInt("bioffer");
					int paymentplan = rs.getInt("paymentplan");
					int paymentsmade = rs.getInt("paymentsmade");
					int paymentsremain = rs.getInt("paymentsremain");
					System.out.print("Cususername: " +cususername);
					System.out.print(", Bioffer: " +bioffer);
					System.out.print(", Paymentplan: " +paymentplan);
					System.out.print(", Payments made: " +paymentsmade);
					System.out.print(", Payments Remaining: " +paymentsremain);					
		}
		rs.close();
			} catch(Exception e) {
				if (e.getMessage().contains("This bicycle is no longer available as it has recently been purchased by another customer"))
				throw new BiOfferAcceptedandBicycleOwnedException();
			}
return customer;
			
		
	
	}

	@Override //working on still
	public void ViewPendingOffers() throws BiOfferAcceptedandBicycleOwnedException {
		
			try (Connection con = conn.getConnection()){
				Customer customer = new Customer();
			con.setAutoCommit(false);	
		String sql  ="SELECT FROM customer (cususername, bioffer, paymentplan) VALUES(?, ?, ?)";
		PreparedStatement pmpt = con.prepareStatement(sql);
		pmpt.setString(1, customer.getCususername());
		pmpt.setInt(2, customer.getBioffer());
		pmpt.setInt(3, customer.getPaymentplan());
		
		ResultSet rs = pmpt.executeQuery();
		while (rs.next()) {
			String cususername = rs.getString("cususername");
					int bioffer = rs.getInt("bioffer");
					int paymentplan = rs.getInt("paymentplan");
					System.out.print("Cususername: " +cususername);
					System.out.print(", Bioffer: " +bioffer);
					System.out.print(", Paymentplan: " +paymentplan);
		}
		rs.close();
			} catch(Exception e) {
				if (e.getMessage().contains("This bicycle is no longer available as it has recently been purchased by another customer"))
				throw new BiOfferAcceptedandBicycleOwnedException();
			}
return;

	}



	@Override //should work in theory havnt tested yet
	public Bicycles EditExisting(Bicycles bicycles, Bicycles bicyclesold) throws NonUniqueUsernameException {
		
		
		try (Connection con = conn.getConnection()){
			//taking the old user inputted values into the bicyclesold object and regetting them back into boolean, string, int form
			//then setting the new user inputted values at the old values locations in the sql database at least thats what i think i'm doing lol
			con.setAutoCommit(false);	
			int bimodelold = (bicyclesold.getBimodel());
			boolean biavailableold = bicyclesold.isBiavailable();
			String binameold = bicyclesold.getBiname();
			String sql ="UPDATE FROM bicycles (bimodel, biavailable, biname) WHERE VALUES(bimodelold, biavailableold, binameold)";
			PreparedStatement pmpt = con.prepareStatement(sql);
			pmpt.setInt(1, bicycles.setBimodel(bimodelold));
			pmpt.setBoolean(2, bicycles.isBiavailable(biavailableold));
			pmpt.setString(2, bicycles.setBiname(binameold));
			pmpt.executeUpdate();
			ResultSet rs = pmpt.getGeneratedKeys();
			
			while (rs.next()) {
				con.commit(); 
					} 
		} catch (Exception e ) {
			if (e.getMessage().contains("violates unique constraint")) {
				throw new NonUniqueUsernameException();
			}
		} 
		return bicycles;
		}
		
	


	@Override //works 
	public void AddCustomer(Customer customer) throws Exception {
		
		Customer c = null;
		
		try (Connection con = conn.getConnection()){
			con.setAutoCommit(false);
			String sql ="INSERT INTO customer  VALUES(default, ?, ?)";
			String[] keys = {"cusid"};
			PreparedStatement pmpt = con.prepareStatement(sql, keys);
			pmpt.setString(1, customer.getCususername());
			pmpt.setString(2, customer.getCuspassword());
			pmpt.executeUpdate();
			ResultSet rs = pmpt.getGeneratedKeys();
			
			while (rs.next()) {
				 Customer custard = new Customer();
				c = custard;
				c.setCusid(rs.getInt(1));
				con.commit(); 
				if(c.equals(null)) {
					con.rollback(); } } 
		} catch (Exception e ) {
			if (e.getMessage().contains("violates unique constraint")) {
				throw new NonUniqueUsernameException();
			} 
		} 
		return;
		}

	@Override //works 
	public Bicycles RemoveBi(Bicycles bicycles) throws SQLException {
		
		
		try (Connection con = conn.getConnection()){
			con.setAutoCommit(false);
			String sql ="DELETE FROM bicycles VALUES(?, ?, ?)";
			PreparedStatement pmpt = con.prepareStatement(sql);
			pmpt.setBoolean(1, bicycles.isBiavailable(true));
			pmpt.setInt(2, bicycles.getBimodel());
			pmpt.setString(3, bicycles.getBiname());
			pmpt.executeUpdate(); 
			if(bicycles.equals(null)) {
				con.commit(); }  
			else{
				con.rollback();
			}} catch (Exception e) {
				e.printStackTrace();
				log.debug("Exception thrown when trying to delete bicycle entered: "+bicycles.toString());
			}
		return bicycles;
	}

	@Override //works 
	public Bicycles AddBi(Bicycles bicycles) throws Exception {
		
		try (Connection con = conn.getConnection()){
			con.setAutoCommit(false);
			log.info("Attempting to add the entered bicycles values from the system: "+bicycles.toString());
			String sql ="INSERT INTO bicycles  VALUES(?, ?, ?)";
			PreparedStatement pmpt = con.prepareStatement(sql);
			pmpt.setBoolean(1, bicycles.isBiavailable(true));
			pmpt.setInt(2, bicycles.getBimodel());
			pmpt.setString(3, bicycles.getBiname());
			pmpt.executeUpdate();
				con.commit();
				log.info("Bicycles values were added successfully: "+bicycles.toString());
			}	catch(Exception e ) {
				log.debug("Exception thrown when trying to add: "+bicycles.toString());
	}
		return bicycles;
		}
	

	@Override //works 
	public Employee EmpLogin() throws Exception {
	
		Employee employee = new Employee();
	try (Connection con = conn.getConnection()){

		con.setAutoCommit(false);
		String sql  ="SELECT FROM employee (empusername, emppassword) VALUES(?, ?)";
		PreparedStatement pmpt = con.prepareStatement(sql);
		
		pmpt.setString(1, employee.getEmpusername());
		pmpt.setString(2, employee.getEmppassword());
		pmpt.executeQuery();
		 } catch (Exception e) {
				if (e.getMessage().contains("violates unique constraint")) {
					throw new NonUniqueUsernameException();
			}     
	}
	return employee;
}
	
}