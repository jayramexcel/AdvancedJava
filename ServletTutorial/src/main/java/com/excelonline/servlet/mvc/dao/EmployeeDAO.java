package com.excelonline.servlet.mvc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.excelonline.servlet.mvc.model.Employee;

/**
 * @author Jayram Rout
 *
 */
public class EmployeeDAO {
	private static Logger log = Logger.getLogger(EmployeeDAO.class);
	private final String INSERT ="INSERT INTO EMPLOYEES(EMPLOYEE_ID , FIRST_NAME, LAST_NAME , EMAIL , HIRE_DATE , JOB_ID) VALUES(EMPLOYEES_SEQ.NEXTVAL, ?,?,?,sysdate,?)";
	private final String SELECT ="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
	private final String SELECT_ALL = "SELECT * FROM EMPLOYEES";
	
	static Connection con = null;
	static Statement stmt =null;
	static PreparedStatement pstmt = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	static String connectionURL = "jdbc:oracle:thin:@localhost:1521/XE";
	private void loadDriver() throws ClassNotFoundException{
		try{
			Class.forName(driver);
		}catch(ClassNotFoundException exp){
			exp.printStackTrace();
			log.error("Issues in Class Not Found"+ exp.getMessage());
			throw exp;
		}
	}
	/**
	 * 
	 * @return
	 */
	private Connection getConnection(){
		try{
			con = DriverManager.getConnection(connectionURL,"HR","HR");
		}catch(Exception exp){
			exp.printStackTrace();
		}
		return con;
	}
	/**
	 * 
	 * @param employeeID
	 * @return
	 * @throws Exception
	 */
	public List<Employee> selectEmployees(int employeeID) throws Exception {
		List<Employee> employeeList = new ArrayList<Employee>();
		try{
			loadDriver();
			con = getConnection();
			
			con.setAutoCommit(false);
			if(employeeID == 0)
				pstmt = con.prepareStatement(SELECT_ALL);
			else{
				pstmt = con.prepareStatement(SELECT);
				pstmt.setInt(1, employeeID);
			} 
			rs = pstmt.executeQuery();
			Employee emp = null;
			while(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				employeeList.add(emp);
			}
		}catch(ClassNotFoundException cnfe){
			throw cnfe;
		}catch(Exception exp){
			exp.printStackTrace();
			try{
				con.rollback();
			}catch(Exception exp1){
				throw exp1;
			}
			throw exp;
		}finally{
			closeConnections(rs,stmt,con);
		}

		return employeeList;
	}
	/**
	 * 
	 * @param fname
	 * @param lname
	 * @param email
	 * @param jobID
	 * @throws Exception
	 * @throws ClassNotFoundException
	 */
	public void insertEmployee(String fname, String  lname , String  email , String jobID ) throws Exception , ClassNotFoundException{
		try{
			loadDriver();
			con = getConnection();
			
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, email);
			pstmt.setString(4, jobID);
			int intValue = 0;
			intValue = pstmt.executeUpdate();

			log.info("Return value from insert "+ intValue);
		}catch(ClassNotFoundException cnfe){
			throw cnfe;
		}catch(Exception exp){
			exp.printStackTrace();
			try{
				con.rollback();
			}catch(Exception exp1){
				throw exp1;
			}
			throw exp;
		}finally{
			closeConnections(rs,stmt,con);
		}
	}
	private void closeConnections(ResultSet rs , Statement stmt , Connection con){
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(con != null){
				con.close();
			}
		}catch(Exception exp){
			exp.printStackTrace();
		}
	}
}
