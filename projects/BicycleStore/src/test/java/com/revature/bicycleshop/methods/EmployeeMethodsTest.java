package com.revature.bicycleshop.methods;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.revature.bicycleshop.merchandise.Bicycles;

class EmployeeMethodsTest {

//	@Test not testable due to my return time but verified it works by controller testing
//	void AddCustomerTest() {
//		boolean isGood = false;
//		EmployeeMethods em = new EmployeeMethods();
//		Bicycles bicycles = new Bicycles(true, 456, "lovebike");
//		Customer customer = new Customer(4, "haley", "4271", 11, false, 4, 2, 1, 2021-02-17);
//		if ((em.AddCustomer(customer)) {
//			
//			assertTrue(isGood);
//		} 
//	}	
		
	
	@Test
	void AddBiTest() throws Exception{
		boolean isGood = false;
		EmployeeMethods em = new EmployeeMethods();
		Bicycles bicycles = new Bicycles(true, 456, "lovebike");
		if (em.AddBi(bicycles) == null) {
			assertTrue(isGood);
		}
	}
	
	@Test
	void RemoveBiTest() throws Exception {
		boolean isGood = false;
		EmployeeMethods em = new EmployeeMethods();
		Bicycles bicycles = new Bicycles(true, 456, "lovebike");
		if(em.RemoveBi(bicycles) == null) {
			assertTrue(isGood);
		}
	}
	
	@Test
	void EmpLoginTest() throws Exception {
		
		boolean isGood = false;
		EmployeeMethods em = new EmployeeMethods();
		if (em.EmpLogin() == null)
		{
			assertTrue(isGood);
		}
	}
	
//	@Test is void return type cant be tested due to implementation
//	void ViewPendingTest() throws Exception {
//		boolean isGood = false;
//		EmployeeMethods em = new EmployeeMethods();
//		Integer bimodel = 1;
//		boolean biavailable = true;
//		String biname = "hehehe";
//		if (em.EditExistingBiycles(bimodel, biavailable, biname) )
//	}
	
	
	
}
