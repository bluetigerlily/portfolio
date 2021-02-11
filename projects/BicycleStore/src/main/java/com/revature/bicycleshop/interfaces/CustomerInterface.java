package com.revature.bicycleshop.interfaces;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Wrapper;
import java.util.*;
import java.util.concurrent.Executor;

import com.revature.bicycleshop.exceptions.NonUniqueUsernameException;
import com.revature.bicycleshop.interfaces.*;
import com.revature.bicycleshop.merchandise.Bicycles;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import com.revature.bicycleshop.users.*;
import org.apache.log4j.Logger;


public interface CustomerInterface {

	
		
		int MakeOfferBiOffer(int bioffer) throws SQLException;
		int MakeOfferPaymentPlan(int paymentplan) throws SQLException;
		List<Customer> ViewOwned(boolean biowned) throws SQLException;
		int ViewPaymentsRemaining(int paymentsremain) throws SQLException;
		List<Bicycles> getAvailable(boolean biavailable) throws SQLException;
		String CusLoginPassword(String password) throws SQLException;
		String CusLoginName(String username) throws SQLException;
		Customer CreateCustomer(Customer input) throws NonUniqueUsernameException;
}
