package com.excelonline.jsp.dao;

import java.util.List;

import com.excelonline.jsp.dataobject.EmployeeDO;

public interface EmployeeDetailDAO{
	/**
	 * 
	 * @param empid
	 * @return
	 */
	public EmployeeDO getEmpDetail(String empid);
	public List<EmployeeDO> getEmployees();
}