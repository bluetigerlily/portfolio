package com.revature.bicycleshop.users;

public class Customer extends Employee {
	
	
	
	//going to use Customer as my generic customer user
		/*
		 * Customer Variables
		 * cususername - string to store the username variable 
		 * cuspassword - string to store the password variable
		 * biavailable - boolean will be true or false if true display to customer the bicycle is available if false don't display
		 * bioffer - Integer will be used to calculate paymentplan and paymentsremain
		 * biowned - boolean will be true or false if true display to customer the bicycle is owned if false don't display
		 * bimodel - Integer will be identifier of the bicycle type
		 * paymentplan - Integer will be the weekly number of payments required to pay off the price of bicycle
		 * paymentsmade - Integer will be number of weekly payments made to date
		 * paymentsremain - Integer number of payments remaining is (bioffer/paymentplan)-paymentsmade
		 * date - Integer to store the date
		 */
	
	
	
		private static Integer cusid;
		private static String cususername;
		private static String cuspassword;
		public static boolean biavailable;
		private static int bioffer; //needs to be joined to bipending in employee table and bimodel in bicycles table
		public static boolean biowned; //needs to be joined to bimodel in bicycles table
		public static Integer paymentplan;//make note this is linked with bioffer
		public static Integer paymentsmade;
		public static Integer paymentsremain;
		public static Integer date;
		
		
		
		//getters and setters
		
		@Override
		public String toString() {
			return "Customer [getCususername()=" + getCususername() + ", getCuspassword()=" + getCuspassword()
					+ ", getBioffer()=" + getBioffer() + ", getPaymentplan()=" + getPaymentplan()
					+ ", getPaymentsremain()=" + getPaymentsremain() + ", getPaymentsmade()=" + getPaymentsmade()
					+ ", getCusid()=" + getCusid() + ", getEmppassword()=" + getEmppassword() + ", getEmpusername()="
					+ getEmpusername() + ", isEmploystatus()=" + isEmploystatus() + ", isBiavailable()="
					+ isBiavailable() + ", getBiname()=" + getBiname() + ", getBimodel()=" + getBimodel()
					+ ", getManpassword()=" + getManpassword() + ", getManusername()=" + getManusername()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}

		public Customer(Integer cusid, String cususername, String cuspassword, int bioffer, boolean biowned, Integer paymentplan, Integer paymentsmade, Integer paymentsremain, Integer date)
		{
			super();
			Customer.cusid = cusid;
			Customer.cususername = cususername;
			Customer.cuspassword = cuspassword;
			Customer.bioffer = bioffer;
			Customer.biowned = biowned;
			Customer.paymentplan = paymentplan;
			Customer.paymentsmade = paymentsmade;
			Customer.paymentsremain = paymentsremain;
			Customer.date = date;
		}
			
		public Customer() {
		}




		public Customer(int i, String string, String string2) {
			
		}

		public Customer(String string, String string2) {
			
		}

		public String getCususername() {
			return cususername;
		}
		public void setCususername(String cususername) {
			Customer.cususername = cususername;
		}
		public String getCuspassword() {
			return cuspassword;
		}
		public void setCuspassword(String cuspassword) {
			Customer.cuspassword = cuspassword;
		}
		public boolean isBiavailable(boolean biavailable) {
			return biavailable;
		}
		public void setBiavailable(boolean biavailable) {
			Customer.biavailable = biavailable;
		}
		public int getBioffer() {
			return bioffer;
		}
		public void setBioffer(int bioffer) {
			Customer.bioffer = bioffer;
		}
		public boolean isBiowned(boolean biowned) {
			return biowned;
		}
		public static void setBiowned(boolean biowned) {
			Customer.biowned = biowned;
		}
		public Integer getPaymentplan() {
			return paymentplan;
		}
		public void setPaymentplan(Integer paymentplan) {
			Customer.paymentplan = paymentplan;
		}
		public Integer getPaymentsremain() {
			return paymentsremain;
		}
		public void setPaymentsremain(Integer paymentsremain) {
			Customer.paymentsremain = paymentsremain;
		}
		public Integer getPaymentsmade() {
			return paymentsmade;
		}
		public void setPaymentsmade(Integer paymentsmade) {
			Customer.paymentsmade = paymentsmade;
		}
		public Integer getCusid() {
			return cusid;
		}

		public void setCusid(Integer cusid) {
			Customer.cusid = cusid;
		}


		public void setCustomer(Customer createCustomer) {
			
			
		}




}
