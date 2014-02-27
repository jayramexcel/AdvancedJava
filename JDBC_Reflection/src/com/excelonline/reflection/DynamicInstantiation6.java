package com.excelonline.reflection;
import java.lang.reflect.Method;


public class DynamicInstantiation6 {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		print("com.excelonline.reflection.PrintMe");
	}
	public static void print(String empType) throws Exception{ 
		
//		Employee e = new HourlyEmployee(); 
//		e.print();

		
		Class c = Class.forName(empType); 
		PrintMe emp = (PrintMe) c.newInstance(); 
//		emp.callMe(); 
//		
//		//Class c = emp.getClass(); 
//		Method m = c.getMethod("print", null); 
//		m.invoke(emp, null);
//		
		}
}
