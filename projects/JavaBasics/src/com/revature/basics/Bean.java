package com.revature.basics;

import java.util.Arrays;

public class Bean {
	
	public String type;
	public String color;
	public Integer size;
	public Boolean isCooked;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((isCooked == null) ? 0 : isCooked.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bean other = (Bean) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (isCooked == null) {
			if (other.isCooked != null)
				return false;
		} else if (!isCooked.equals(other.isCooked))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



	//no args constructor
	public Bean() {
		type ="pinto";
		color="tan";
		size=3;
		isCooked=false;
	}
	
	
	
	//overloaded constructor
	public Bean(String type, String color, Integer size, Boolean isCooked) {
		
		this.type =type;
		this.color =color;
		this.size =size;
		this.isCooked =isCooked;
		
	}

	//varargs (variable argument)
	public void beanMethod(String...str) {
		for (String string : str) {
			System.out.println("greeting "+string);
		}
	}
	
	public Bean(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
