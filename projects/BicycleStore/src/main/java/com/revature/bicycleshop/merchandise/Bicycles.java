package com.revature.bicycleshop.merchandise;

public class Bicycles {
	
	
	
	public static Integer bimodel;
	public static String biname;
	private static boolean biavailable;
	public static Integer date;
	private static boolean bioffer;
	
	public Bicycles() {
		
	}
	
	public Bicycles(Integer bimodel, String biname, boolean biavailable, Integer date, boolean bioffer)
	{
		super();
		Bicycles.bimodel = bimodel;
		Bicycles.biname = biname;
		Bicycles.biavailable = biavailable;
		Bicycles.date = date;
		Bicycles.bioffer = bioffer;
	}

	public static boolean isBiavailable() {
		return biavailable;
	}

	public void setBiavailable(boolean biavailable) {
		Bicycles.biavailable = biavailable;
	}
	public static void setDate(Integer date) {
		Bicycles.date = date;
	}

	public static boolean isBioffer() {
		return bioffer;
	}

	public static void setBioffer(boolean bioffer) {
		Bicycles.bioffer = bioffer;
	}
	
	public void setBimodel(Integer bimodel) {
		Bicycles.bimodel = bimodel;
	}


	
		



	

}