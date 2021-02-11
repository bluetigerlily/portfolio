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
	
	Logger log = Logger.getLogger(CustomerMethods.class.getName());
	private Set<Customer> Customers;
	
	
	public CustomerMethods() {
	
		
		Customers = new HashSet<>();
	}
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
	
	
//	@Override
//	public void CreateCustomer(String cususername, String cuspassword) throws SQLException {
//		
//		
//		try (Connection connection = Connector.get_connection())
//	
//		{
//						
//			String sqb = "INSERT INTO bicyclestoreschema.'customer'\r\n"
//					+"(cususername, cuspassword) \r\n"
//								+"VALUES();";
//	
//			PreparedStatement preparedStatement =connection.prepareStatement(sqb);
//			preparedStatement.setString(1,Customer.getCususername());
//			preparedStatement.setString(2, Customer.getCuspassword());
//			
//		
//			
//		}
//	catch (SQLException e)
//		{
//		System.out.println(e.getMessage());
//		throw new SQLException("Internal Error Occured Please Contact the System Admin. ");
//		}
//		return;
//		
//	}
	
	@Override
	public  List<Bicycles> getAvailable(boolean biavailable) throws SQLException {
		
		String szz ="SELECT * From bicyclestoreschema.'bicycles' WHERE biavailable =? ";
		
		
		List<Bicycles> getAvailableList = new ArrayList<>();
		try (Connection connection = Connector.get_connection())
		{
			
			
			
			PreparedStatement preparedStatemnet = connection.prepareStatement(szz);
			ResultSet rs = preparedStatemnet.executeQuery();
			
		while(rs.next())
		{
			Bicycles bicycles = new Bicycles();
			bicycles.setBiavailable(rs.getBoolean("biavailable"));
			getAvailableList.add(bicycles);
			
		} if (getAvailableList.size()==0)
		{
			return null;
		}
		else
		
			return getAvailableList;
		}
	}

//
//	@Override
//	public int MakeOffer(int bioffer, int paymentplan) throws SQLException {
//	
//		
//		
//		String sww ="SELECT * From bicyclestoreschema.'customer' WHERE biavailable, cususername, cuspassword =? ";
//		
//		String syy ="INSERT * From bicyclestoreschema.'customer' WHERE bioffer, paymentplan =? ";
//		
//		try (Connection connection = Connector.get_connection())
//		{
//			
//			
//			
//			PreparedStatement preparedStatemnet1 = connection.prepareStatement(sww);
//			ResultSet rt = preparedStatemnet1.executeQuery();
//			
//			PreparedStatement preparedStatemnet = connection.prepareStatement(syy);
//			ResultSet rs = preparedStatemnet.executeQuery();
//			
//			while(rs.next())
//			{
//				Customer customer = new Customer();
//				customer.setBioffer(rs.getInt("bioffer"));
//				customer.setPaymentplan(rs.getInt("paymentplan"));
//				
//			}
//		}
//			catch (SQLException ex) {
//				System.out.println(ex.getMessage());
//			}
//		
//		return bioffer;
//		
//	}
	@Override
	public List<Customer> ViewOwned(boolean biowned) throws SQLException {
		
		
		
		String spp ="SELECT * From bicyclestoreschema.'customer' WHERE biowned =? ";
		
		List<Customer> ListBiowned = new ArrayList<>();
		
		
		try (Connection connection = Connector.get_connection())
		{
			PreparedStatement preparedStatemnet = connection.prepareStatement(spp);
			ResultSet rs = preparedStatemnet.executeQuery();
			while(rs.next())
			{
				Customer customer = new Customer();
				Customer.setBiowned(rs.getBoolean("true"));
				ListBiowned.add(customer);
				if(ListBiowned.size()==0)
				{
					return null;
				}
				else
					
					return ListBiowned;
			}
		} catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return ListBiowned;
	}

//	@Override
//	public int ViewPaymentsRemaining(int paymentsremain) throws SQLException {
//		
//	
//		
//		String stt ="SELECT * From bicyclestoreschema.'customer' WHERE paymentsremain =? ";
//		
//		try (Connection connection = Connector.get_connection())
//		{
//			PreparedStatement preparedStatemnet = connection.prepareStatement(stt);
//			ResultSet rs = preparedStatemnet.executeQuery();
//			while(rs.next());
//			{
//				Customer customer = new Customer();
//				
//				int q=rs.getInt("paymentsremain");
//			int paymentsremain1 = rs.getInt("paymentsremain");
//			
//			
//			}
//			
//		}catch (SQLException ex)
//			{
//				System.out.println(ex.getMessage());
//			}
//			
//		
//		return paymentsremain;
//		
//	}
@Override
	public String CusLoginName(String username) throws SQLException{
		
	String cususername  ="SELECT * From bicyclestoreschema.'customer' WHERE cususername =?";
		try (Connection connection = Connector.get_connection())
		{
			PreparedStatement pmpt = connection.prepareStatement(cususername);
			
			ResultSet rs = pmpt.executeQuery();
			
			while(rs.next());
			{
				Customer customer = new Customer();
				customer.setCususername(rs.getString("username"));
				return cususername;
		
	}
		}
}
	@Override
	public String CusLoginPassword(String password) throws SQLException {
String cuspassword ="SELECT * From bicyclestoreschema.'customer' WHERE cuspassword =?";
		
		try (Connection connection = Connector.get_connection())
		{
			PreparedStatement pmpt = connection.prepareStatement(cuspassword);
			ResultSet rs = pmpt.executeQuery();
			while(rs.next());
			{
			Customer customer = new Customer();	
			customer.setCuspassword(rs.getString("password"));
			}
		
		return cuspassword;
	}
	}


	@Override
	public int MakeOfferBiOffer(int bioffer) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int MakeOfferPaymentPlan(int paymentplan) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ViewPaymentsRemaining(int paymentsremain) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	@Override
	public Customer CreateCustomer(Customer input) throws NonUniqueUsernameException {
		String newcustomer ="INSERT * From bicyclestoreschema.'customer' WHERE cususername =?";
		try (Connection connection = Connector.get_connection())
		{
			 PreparedStatement pmpt = connection.prepareStatement(newcustomer);
					ResultSet rs = pmpt.executeQuery();
					
		for (Customer c : Customers) {
			if (c.getCususername().equals(input.getCususername())) {
				throw new NonUniqueUsernameException();
			}
		
		}
		input.setCusid(Customers.size()+1);
		Customers.add(input); 
		} catch (SQLException ex){
			System.out.println(ex.getMessage());
			
		}
		
		return input;
}
}












	
		
		