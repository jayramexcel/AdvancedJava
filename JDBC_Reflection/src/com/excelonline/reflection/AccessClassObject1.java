package com.excelonline.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AccessClassObject1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c = "OOP".getClass();

		System.out.println("First -"+c);
		System.out.println("First -"+c.getName());	//java.lang.String
		System.out.println("First getSimpleName()-"+c.getSimpleName());	//java.lang.String


		c = String.class;
		System.out.println("Second -"+c);	//class java.lang.String

		try{
			//c = Class.forName("com.excel.reflection.Testing");
			c = Class.forName("java.lang.String");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Third "+c);	


		Class s = c.getSuperclass();
		String name = s.getName();

		System.out.println("SuperClass "+name);


		Field[] fields = c.getFields();
		System.out.println("***************************FIELDS******************************");
		for(int i=0;i<fields.length;i++){
			System.out.println(fields[i]);
		}
		System.out.println("***************************FIELDS ENDS ******************************");

		System.out.println("***************************METHODS******************************");
		Method[] methodsArray = c.getMethods();
//		for(int i=0;i<methods.length;i++){
//			System.out.println("AccessClassObject1.main() " + methods[i].getName());
//		}
		//Enhanced Foor Loop
		for(Method met : methodsArray){
			System.out.println("Ehanced.main() " + met.getName());
		}
		
		System.out.println("***************************METHOD ENDS******************************");

		System.out.println("***************************INTERFACES******************************");
		Class[] interaces = c.getInterfaces();
		for(int i=0;i<interaces.length;i++){
			System.out.println(interaces[i].getName());
		}
		System.out.println("***************************INTERFACES ENDS******************************");
	}

}
