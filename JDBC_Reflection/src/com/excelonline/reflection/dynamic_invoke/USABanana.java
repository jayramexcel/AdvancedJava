package com.excelonline.reflection.dynamic_invoke;

public class USABanana implements Banana {

	@Override
	public void length() {
		System.out.println("USABanana.length() is USA 10");
	}
	
	public void isYellow(){
		System.out.println("The color is Dark Yello");
	}
}
