package com.revature.bicycleshop.merchandise;

public class Bicycles {
	
	
	
	public static Integer bimodel;
	public static String biname;
	private static boolean biavailable;
	public static Integer date;
	private static boolean bioffer;
	
	
	public Bicycles(boolean biavailable, Integer bimodel, String biname)
	{
		super();
		Bicycles.biavailable = biavailable;
		Bicycles.bimodel = bimodel;
		Bicycles.biname = biname;
		
	}

	public Bicycles() {
		
	}

	public boolean isBiavailable(boolean b) {
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
	
	public Integer setBimodel(Integer bimodel) {
		return Bicycles.bimodel = bimodel;
	}

	public Integer getBimodel() {
		
		return bimodel;
	}
	public String getBiname() {
		return biname;
	}

	public String setBiname(String biname) {
		return Bicycles.biname = biname;
		
	}

	public boolean isBiavailable() {
		// TODO Auto-generated method stub
		return biavailable;
	}
	
	
	


	
		



	

}
