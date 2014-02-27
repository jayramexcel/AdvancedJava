package com.excelonline.reflection.dynamic_invoke;

public class IndianBanana implements Banana {
	
	@Override
 	public void length() {
 		System.out.println("IndianBanana.length() INDIAN 15");
 	}
	
	public void isGreen() {
		System.out.println("IndianBanana.isGreen().....");
	}
}