package com.revature.bicycleshop.users;

public class Users {

	
	private static String cususername;
	private static String cuspassword;
	private static boolean biavailable;
	private static Integer bioffer;
	private static boolean biowned;
	public static Integer bimodel;
	private static Integer paymentplan;
	private static Integer paymentsmade;
	private static Integer paymentsremain;
	public static Integer date;
	private static boolean bipending;
	private static String empusername;
	private static String emppassword;
	private static boolean employstatus;
	private static String manusername;
	private static String manpassword;
	private static Integer sales;
	private static Integer missedsales;
	
	
	public Users(String cususername, String cuspassword, boolean biavailable, Integer bioffer, boolean biowned,Integer bimodel, Integer paymentplan, Integer paymentsmade, Integer paymentsremain, Integer date, boolean bipending, String empusername, String emppassword, boolean employstatus, String manusername, String manpassword, Integer sales, Integer missedsales)
	{
		super();
		Users.setCususername(cususername);
		Users.setCuspassword(cuspassword);
		Users.setPaymentplan(paymentplan);
		Users.setPaymentsmade(paymentsmade);
		Users.setPaymentsremain(paymentsremain);
		Users.setBipending(bipending);
		Users.setEmpusername(empusername);
		Users.setEmppassword(emppassword);
		Users.setEmploystatus(employstatus);
		Users.setManusername(manusername);
		Users.setManpassword(manpassword);
		Users.setSales(sales);
		Users.setMissedsales(missedsales);
		Users.date = date;
	}
	
	public Users()
	{
	}
	public static String getCususername() {
		return cususername;
	}
	public static void setCususername(String cususername) {
		Users.cususername = cususername;
	}
	public static String getCuspassword() {
		return cuspassword;
	}
	public static void setCuspassword(String cuspassword) {
		Users.cuspassword = cuspassword;
	}
	public static boolean isBiavailable() {
		return biavailable;
	}
	public static void setBiavailable(boolean biavailable) {
		Users.biavailable = biavailable;
	}
	public static Integer getBioffer() {
		return bioffer;
	}
	public void setBioffer(Integer bioffer) {
		Users.bioffer = bioffer;
	}
	public static boolean isBiowned() {
		return biowned;
	}
	public static void setBiowned(boolean biowned) {
		Users.biowned = biowned;
	}
	public static Integer getPaymentplan() {
		return paymentplan;
	}
	public static void setPaymentplan(Integer paymentplan) {
		Users.paymentplan = paymentplan;
	}
	public static Integer getPaymentsmade() {
		return paymentsmade;
	}
	public static void setPaymentsmade(Integer paymentsmade) {
		Users.paymentsmade = paymentsmade;
	}
	public String getEmpusername() {
		return empusername;
	}
	public static void setEmpusername(String empusername) {
		Users.empusername = empusername;
	}
	public static boolean isEmploystatus() {
		return employstatus;
	}
	public static void setEmploystatus(boolean employstatus) {
		Users.employstatus = employstatus;
	}
	public String getManusername() {
		return manusername;
	}
	public static void setManusername(String manusername) {
		Users.manusername = manusername;
	}
	public static String getManpassword() {
		return manpassword;
	}
	public static void setManpassword(String manpassword) {
		Users.manpassword = manpassword;
	}
	public static String getEmppassword() {
		return emppassword;
	}
	public static void setEmppassword(String emppassword) {
		Users.emppassword = emppassword;
	}
	public static Integer getPaymentsremain() {
		return paymentsremain;
	}
	public static void setPaymentsremain(Integer paymentsremain) {
		Users.paymentsremain = paymentsremain;
	}
	public static Integer getSales() {
		return sales;
	}
	public static void setSales(Integer sales) {
		Users.sales = sales;
	}
	public static Integer getMissedsales() {
		return missedsales;
	}
	public static void setMissedsales(Integer missedsales) {
		Users.missedsales = missedsales;
	}
	public static boolean isBipending() {
		return bipending;
	}
	public static void setBipending(boolean bipending) {
		Users.bipending = bipending;
	}
} 
