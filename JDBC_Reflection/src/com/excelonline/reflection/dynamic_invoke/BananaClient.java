package com.excelonline.reflection.dynamic_invoke;

import java.lang.reflect.Method;

public class BananaClient {

	public static void main(String[] args) throws Exception {
		IndianBanana ib = new IndianBanana();
		USABanana ub = new USABanana();
		SingaporeBanana sb = new SingaporeBanana();
		
		invokeGreenMethod(ib);
		invokeGreenMethod(ub);
		invokeGreenMethod(sb);
}
	
	public static void invokeGreenMethod(Object obj) throws Exception {
		Class c = obj.getClass();
		Method[] method = c.getMethods();
		for(Method meth : method) {
			if("isGreen".equals(meth.getName())){
				Method m = c.getMethod(meth.getName(), null);
				m.invoke(obj, null);
			}
			
			if("length".equals(meth.getName())){
				Method m = c.getMethod(meth.getName(), null);
				m.invoke(obj, null);
			}
		}
	}
}
