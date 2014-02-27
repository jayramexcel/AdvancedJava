package com.excelonline.jdbc;

public class ArgumentTest {
	public void printValue(String name){
		System.out.println("Value is =" + name);
	}
	
	public static void main(String arg[]) {
		Class c = new ArgumentTest().getClass();
		System.out.println(c.getName());
	}
}
