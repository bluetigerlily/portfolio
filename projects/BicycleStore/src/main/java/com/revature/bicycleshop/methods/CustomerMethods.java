package com.revature.bicycleshop.methods;


import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.*;
import com.revature.bicycleshop.connector.*;
import com.revature.bicycleshop.exceptions.NonUniqueUsernameException;
import com.revature.bicycleshop.interfaces.*;
import com.revature.bicycleshop.merchandise.Bicycles;
import java.sql.ResultSet;
import com.revature.bicycleshop.users.Customer;
import org.apache.log4j.Logger;



public class CustomerMethods implements CustomerInterface{
	
	
	private Connector conn = Connector.getConnector();
	Logger log = Logger.getLogger(CustomerMethods.class.getName());
	
	
	
	
	/*
	 cususername - string to store the username variable 
	 * cuspassword - string to store the password variable
	 * biavailable - boolean will be true or false if true display to customer the bicycle is available if false don't display
	 * bioffer - int will be used to calculate paymentplan and paymentsremain
	 * biowned - boolean will be true or false if true display to customer the bicycle is owned if false don't display
	 * bimodel - int will be identifier of the bicycle type
	 * paymentplan - int will be the weekly number of payments required to pay off the price of bicycle
	 * paymentsmade - int will be number of weekly payments made to date
	 * paymentsremain - int number of payments remaining is (bioffer/paymentplan)-paymentsmade
	 * date - int to store the date
	 */	
	//needs further testing but good and working for now
	@Override
	public  Set<Bicycles> getAvailable(Bicycles bicycles) throws Exception {
		
		Set<Bicycles> bibi = new HashSet<>();
				
		try (Connection con = conn.getConnection()) {	
		String sql ="SELECT FROM bicycles WHERE (biavailable, bimodel, biname) VALUES(?, ?, ?)";
					con.setAutoCommit(false);
					
		PreparedStatement pmpt = con.prepareStatement(sql);
		pmpt.setBoolean(1, bicycles.isBiavailable(true));
		pmpt.setInt(2, bicycles.getBimodel());
	    pmpt.setString(3, bicycles.getBiname());
					ResultSet rs = pmpt.executeQuery();
		
		while(rs.next()) {
			((Bicycles) bibi).isBiavailable(rs.getBoolean("biavailable"));
			((Bicycles) bibi).setBimodel(rs.getInt("bimodel"));
			((Bicycles) bibi).setBiname(rs.getString("biname"));
			bibi.add(bicycles);
		}
		} catch (Exception e) {
			
		}  
		return bibi;
	}
	
	@Override
	public List<Customer> ViewOwned(Customer customer) throws SQLException {
		
		
		
		@SuppressWarnings("unused")
		String spp ="SELECT FROM customer (biowned) VALUES(?)";
		
		List<Customer> ListBiowned = new ArrayList<>();
		
		
		
		return ListBiowned;
	}

	//good and working
@Override
	public Customer CusLogin() throws Exception{
		
	Customer customer = new Customer();
		try (Connection con = conn.getConnection()){
			
			con.setAutoCommit(false);
			String sql  ="SELECT FROM customer (cususername, cuspassword) VALUES(?, ?)";
			PreparedStatement pmpt = con.prepareStatement(sql);
			
			pmpt.setNString(1, customer.getCususername());
			pmpt.setString(2, customer.getCuspassword());
			pmpt.executeQuery();
			
			 } catch (Exception e) {
					if (e.getMessage().contains("violates unique constraint")) {
						throw new NonUniqueUsernameException();
				}     
		}
		return customer;
}
	
	@Override
	public int ViewPaymentsRemaining(Customer customer) throws Exception {
		
		
		try (Connection con = conn.getConnection()){
			con.setAutoCommit(false);
			String sql ="SELECT FROM customer (cususername, cuspassword, bioffer, biowned, paymentplan, paymentsmade, paymentsremain) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pmpt = con.prepareStatement(sql);
			pmpt.setString(1, customer.getCususername());
			pmpt.setString(2, customer.getCuspassword());
			pmpt.setInt(3, customer.getBioffer());
			pmpt.setBoolean(4, customer.isBiowned(false));
			pmpt.setInt(5, customer.getPaymentplan());
			pmpt.setInt(6, customer.getPaymentsmade());
			pmpt.setInt(7, customer.getPaymentsremain());
			pmpt.executeQuery();
			int x =	customer.getPaymentsremain();
//			ResultSet rs = pmpt.getGeneratedKeys();
//			while (rs.next()) {
//				customer.setCusid(rs.getInt(1));
//				con.commit(); 
//				if(customer.equals(null)) {
//					con.rollback(); } } 
			return x;
		}
	}
		



	
	//good and working
	@Override
	public Customer CreateCustomer(Customer customer) throws Exception{
		
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
		return customer;
		}

	@Override
	public  Customer MakeOffer(Customer customer, Bicycles bicycles) throws Exception {
	
		
		try (Connection con = conn.getConnection()){
			con.setAutoCommit(false);
			String sql ="UPDATE customer VALUES(default, ?, ?, ?, ?, ?)";
			String[] keys = {"cusid"};
			PreparedStatement pmpt = con.prepareStatement(sql, keys);
			pmpt.setString(1, customer.getCususername());
			pmpt.setString(2, customer.getCuspassword());
			pmpt.setInt(3, customer.getBioffer());
			pmpt.setBoolean(4, customer.isBiowned(false));
			pmpt.setInt(5, customer.getPaymentplan());
			pmpt.executeUpdate();
			ResultSet rs = pmpt.getGeneratedKeys();
			
			while (rs.next()) {
				customer.setCusid(rs.getInt(1));
				con.commit(); 
				if(customer.equals(null)) {
					con.rollback(); } } 
		} catch (Exception e ) {
			if (e.getMessage().contains("violates unique constraint")) {
				throw new NonUniqueUsernameException();
			}
		} 
		return customer;
		}

	@Override
	public Customer MakeaPayment(Customer customer) throws Exception {
		
		try (Connection con = conn.getConnection()){
			con.setAutoCommit(false);
			String sql ="UPDATE customer (cususername, cuspassword, paymentsmade, paymentsremain) VALUES(?,?,?,?)";
			PreparedStatement pmpt = con.prepareStatement(sql);
			pmpt.setString(1, customer.getCususername());
			pmpt.setString(2, customer.getCuspassword());
			pmpt.setInt(3, customer.getPaymentsmade());
			pmpt.setInt(4, customer.getPaymentsremain());
			pmpt.executeUpdate();
			
			con.commit(); 
		
		
	} 
		return customer;
	}}
	












	
		
		