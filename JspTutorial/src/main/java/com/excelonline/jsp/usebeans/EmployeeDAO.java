package com.excelonline.jsp.usebeans;


public class EmployeeDAO {
	public static String getSalary(int id , String name){
		//Will hit the db...and get the salary...
		return "10000" + id + " " +name;
	}
}
