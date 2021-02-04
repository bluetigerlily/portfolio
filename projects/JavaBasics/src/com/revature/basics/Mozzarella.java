package com.revature.basics;

public class Mozzarella implements Cheese {
	
	
	@Override
	public void eatCheese() {
		System.out.println("Eatting some mozzarella.");
	}
	public void eatCheese(String silverware) {
		System.out.println("Eatting some mozzarella with a "+ silverware);
	}
}
