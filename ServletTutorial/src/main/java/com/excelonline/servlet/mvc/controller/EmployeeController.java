package com.excelonline.servlet.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.excelonline.servlet.mvc.dao.EmployeeDAO;
import com.excelonline.servlet.mvc.model.Employee;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(name = "MessageView", description = "Employee Controller", urlPatterns = { "/employeeController" })
public class EmployeeController extends HttpServlet {
	private static Logger log = Logger.getLogger(EmployeeController.class);
	private static final long serialVersionUID = 1L;
	String message = "";

	public EmployeeController() {
		message = "EmployeeController";
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		
		String submit = request.getParameter("submit");
		System.out.println("EmployeeController.doGet()" + submit);
		if ("Insert".equals(submit)) {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String jobID = request.getParameter("jobID");
			try {
				EmployeeDAO dao = new EmployeeDAO();
				dao.insertEmployee(fname, lname , email , jobID );
			} catch (ClassNotFoundException exp) {
				exp.printStackTrace();
				throw new ServletException(exp);
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ServletException(ex);
			}
			RequestDispatcher rd1 = request.getRequestDispatcher("MessageView");// success.jsp
			rd1.forward(request, response);

		}else if("Search".equals(submit)) {
			PrintWriter out = response.getWriter();
			String empID = request.getParameter("empID");
			int employeeID = 0;
			if(empID != null && !"".equals(empID)){
				employeeID = Integer.parseInt(empID);
			}
			EmployeeDAO dao = new EmployeeDAO();
			try {
				List<Employee> empList = dao.selectEmployees(employeeID);
//				request.setAttribute("EmployeeList", request);
				for(Employee emp : empList) {
					
					out.println("ID: " + emp.getEmployeeId() + "<br>");
					out.println(", FirstName: " + emp.getFirstName() + "<br>");
					out.println(", LastName: " + emp.getLastName() + "<br>");
					out.println(", Email: " + emp.getEmail() + "<br>");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		doGet(request, response);
	}
}