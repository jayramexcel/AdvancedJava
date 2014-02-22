package com.excelonline.reflection;
import java.lang.reflect.Method;

public class ExploringType2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String name = "java.lang.String"; // java.lang.String
		
		//showType(name);
		showMethods(name);
	}
	public static void showType(String className)
			throws ClassNotFoundException {
		System.out.println("ExploringType2.showType()");
		Class thisClass = Class.forName(className);
		String flavor = thisClass.isInterface() ?
				"interface" : "class";
		System.out.println(flavor + " " + className);
		
		Class parent = thisClass.getSuperclass();
		if (parent != null) {
			System.out.println("extends " + parent.getName());
		}
		
		Class[] interfaces = thisClass.getInterfaces();
		for (int i=0; i<interfaces.length; ++i) {
			System.out.println("implements "+
					interfaces[i].getName());
		}
	}

	static void showMethods(Object o) {
		Class c = o.getClass();
		Method[] theMethods = c.getMethods();
		
		for (Method m : theMethods) {
			String methodString = m.getName();
			System.out.println("Name: " + methodString);
			System.out.println(" Return Type: " +
					m.getReturnType().getName());
			
			Class[] parameterTypes = m.getParameterTypes();
			System.out.print(" Parameter Types:");
			for (Class p : parameterTypes) {
				System.out.print(" " + p.getName());
			}
			System.out.println();
		}
	}
}