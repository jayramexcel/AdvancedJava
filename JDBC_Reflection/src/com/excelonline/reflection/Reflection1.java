package com.excelonline.reflection;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Reflection1 {

	public void callMeOne(){
		
	}
	
	public void callMeTwo(){
		
	}

	public void callMe(){
		System.out.println("Reflection1.callMe..........()");
	}
	public void add(){

	}
	public void subs(){

	}
	
	static void travarse( Object o ){
		for (int n = 0; ; o = o.getClass()) { 
			System.out.println("Level "+ ++n + ": " + o + ".getClass() = " + o.getClass()); 
			if (o == o.getClass()) break; 
		}
	} 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		travarse(new ArrayList());
/*				Class c = new ArrayList().getClass();
				///*		
//				System.out.println("First "+c);	
				
				c = String.class;
//				System.out.println("Second "+c);	
				try{
					c = Class.forName("java.lang.String");		
				}catch(Exception e){
					e.printStackTrace();
				}
		//		
//				System.out.println("Third "+c);	
		//
				Class s = c.getSuperclass();
//				System.out.println("Reflection1.main()" + s);
		//		
				String name = s.getName();
		//
				System.out.println("SuperClass "+name);
		//		
		//
				Field[] fields = c.getFields(); 
//				for(Field field : fields){
//					System.out.println("Reflection1.Fileds()" + field);
//				}
		//		
				Method[] methods = c.getMethods();
//				for(Method method : methods){
//					System.out.println("Reflection1.method()" + method);
//				}
		//		
				Class[] interaces = c.getInterfaces();
//				for(Class clas : interaces){
//					System.out.println("Reflection1.Interface()" + clas);
//				}
		//====================================
				try{
					Reflection1 ref = new Reflection1();
					
//					ref.callMe();
					
					Class clas = ref.getClass();
//					if present
					Method m = clas.getMethod("callMe", null); 
					m.invoke(ref, null);
				
				}catch(Exception exp){
					exp.printStackTrace();
				}
*/	}
}