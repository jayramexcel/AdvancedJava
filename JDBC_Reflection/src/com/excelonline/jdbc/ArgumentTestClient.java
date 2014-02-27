package com.excelonline.jdbc;

public class ArgumentTestClient {
	public static void main(String[] args) {
		ArgumentTest test = new ArgumentTest();
		test.printValue("Hello");
	}
	
	
	public static String callMe(int i , String name) {
		return name+i;
	}
}