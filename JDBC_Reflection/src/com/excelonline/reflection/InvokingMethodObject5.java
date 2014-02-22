package com.excelonline.reflection;
import java.lang.reflect.Method;


public class InvokingMethodObject5 {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Employee e = new HourlyEmployee(); 
		
		Class c = e.getClass(); 
		Method m = c.getMethod("print", null); 
		m.invoke(e, null);
	}
}
