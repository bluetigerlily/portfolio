package com.revature.basics;
import java.util.*;
public class JavaBasics 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//line comment
		 /* 
		  block comment
		 */
		System.out.println("Hello!");
		
		// primitive types
		byte byteVar;		// 1 byte
		short shortVar;  	// 2 byte													 //first letter lowercase then second word is uppercase
		char charVar;		//2 bytes													// for naming conventions of variables
		int intVar=24;			// 4 bytes
		float floatVar;		//4 bytes
		long longVar;       // 8 bytes
		double doubleVar;   // 8 bytes
		boolean boolVar;    //size is JVM dependent
		
		private static final eatingCheese() 
		{
			Mozzarella mozz = new Mozzarella();
			Cheddar cheddar = new Cheddar();
			Cheese mozzCheese = new Mozzarella();
			Cheese cheddarCheese = new Cheddar();
			Cheese[] cheeseArr = new Cheese[2];
			cheeseArr[0] = mozzCheese;
				cheeseArr[1] =cheddarCheese;
			for (Cheese ch: cheeseArr) 
			{
				ch.eatCheese();
			}
			mozz.eatCheese("spoon");
			((Mozzarella) mozzCheese).eatCheese("fork");
		}
		
		public static void animals() {
			Animal cat = new Cat();
			Animal parrot = new Parrot();
			
			Animal animals = new Animal[2];
			animals[0] = cat;
			animals[1] = parrot;
			for (Animal animal : animals) {
				animal.eatFood();
				animal.makeSound();
				System.out.println(animal.numberOfLegs);
			}
		}
		
		
		// reference/object types		//always start with capital Letter in naming convention
		// wrappers are reference types  
		Byte b;
		Short s;
		Character c;
		Integer i =10;
		Float f;
		Long l;
		Double d;
		Boolean bool;
		//allow use of data types where use of primatives isn't allowed
	
		//  Object obj;
		String str = myMethod(intVar);
		System.out.println(str);
		
		
		/*
		 *  arrays are contiguous blocks of memory
		 *  for storing entities of the same
		 *  type
		 */
		int [] intArray =  new int[5];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		intArray[4] = 5;
		
		System.out.println(Arrays.toString(intArray));
		int[] intArray2 = {5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(intArray2));
		
		Bean bean = new Bean();
		System.out.println(bean.type);
		bean = new Bean("pinto", "tan", "3","true");
		System.out.println(bean.type);
		controlFlow();
	}

	private static String myMethod(Integer i) {
		return i.toString();
	}
	private static void controlFlow() {
		int x = 2;
		int y = 20;
		int z = 100;
		
		// if/else statements (conditional statements)
		if (x == y && y++ < z ) 
		{
			System.out.println("hello");
		} else if (x < y || y > z) {
			System.out.println("nothing");
		}
		System.out.println("y: "+ y);
		
		
		Bean bean1 = new Bean();
		Bean bean2 = new Bean();
		
		System.out.println(bean1 == bean2);
		System.out.println(bean1.equals(bean2));
		
		
		//Switch statements
		//can take strings or convertible int types
		switch (x) {
		case 1:
			System.out.println("x is 1");
			break;
		case 2:
			System.out.println("x is 2");
			break;
		case 3:
			System.out.println("x is 3");
			break;
		case 4:
			System.out.println("x is 4, 5, or 6");
			break;
		default:
			System.out.println("x is something else");
			break;
			
			
			// ternary statements
		//String str = x == 10 ? "yes" : "no";
		//str = y < 10 ? z > 10 ? "a" : "b" : "c";
		}
	
		//loops 
	//while loop
	
	while(x < 10) 
	{
		System.out.println("x is now " + x);
		x++;
	}
	
	do {
		x++;
		System.out.println("x is now "+ x);
		
	} while (x < 10);
	for (int i = 1; i <= 10; i++) {
		System.out.println("i is " +i );
	}
	
	int[] intArr = {2, 4, 6, 8};
	for (int i = 0; i < intArr.length; i++) {
		System.out.println(intArr[i]);
		
	for (int num : intArr)
		{
		System.out.println("number is " +num);
		}
	//breaks continues and labels
	myLoop: for (int i1 = 0; i1 < 20; i1++)
	{
		if (i1==10)
			break;
		else if (i1 == 5)
			continue;
		System.out.println("Hello, " +i1);
	}
	}
		rows: for (int i = 0; i < 20; i++){
			cols: for (int j = 0; j < 20; j++){
				if (j==10)
					break;
				else if (i==12)
					break;
			System.out.println("i: "+ i+ " j: "+ j);
				
			}
		}
	}
}
	

	
