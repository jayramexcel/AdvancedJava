package com.excelonline.reflection;

class Employee{
	int number;
	int level;
	public void print(){}
}

class MonthlyEmployee extends Employee{
	public void print(){
		System.out.println("MonthlyEmployee.print() I am Monthly Employee");
	}
}

class HourlyEmployee extends Employee{
	public void print(){
		System.out.println("HourlyEmployee.print() I am from Hourly Employee....");
	}
}

public class DynamicBinding4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Employee e; 
		
		e = new MonthlyEmployee(); 
		Class c = e.getClass(); 
		System.out.println("class of e = " + c.getName()); 
		
		e = new HourlyEmployee(); c = e.getClass(); 
		System.out.println("class of e = " + c.getName());
	}
}

