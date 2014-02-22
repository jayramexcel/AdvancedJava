package com.excelonline.reflection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaObjectModel3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String name = "java.lang.String";
		System.out.println(name.getClass() + " "+ name.getClass().getClass() +" " + name.getClass().getClass().getClass()+"\n");
		
		travarse(name);
	}
	static void travarse( Object o ){ 
		for (int n = 0; ; o = o.getClass()) { 
			System.out.println("Level "+ ++n + ": " + o + ".getClass() = " + o.getClass()); 
			if (o == o.getClass()) break; 
		} 
	} 

}

