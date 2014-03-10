package com.excelonline.servlet.formdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 * @WebServlet(description = "My Hello World", urlPatterns = { "/HelloWorld" })
 */
@WebServlet(description = "Hello Form", urlPatterns = { "/login/helloForm" })
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message = "";
	
	public HelloForm() {
		message = "Hello World";
		
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("In the init Method of HelloForm");
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      List isAuthenticatedList = (ArrayList)request.getAttribute("isAuthenticated");
	      
	      System.out.println("HelloForm.doPost() isAuthenticated  ==== "+ isAuthenticatedList);
	      /*
	       * getParameterNames : Its captures all the field names(not the value) from the form
	       */
	      Enumeration enume = request.getParameterNames();
	      while(enume.hasMoreElements()) {
	    	  String value = (String)enume.nextElement();
	    	  System.out.println("HelloForm.doPost()"+ value + " Value = " + request.getParameter(value));
	      }
	      
		  String title = "Using GET Method to Read Form Data";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>First Name</b>: "
	                + request.getParameter("first_name") + "\n" +
	                "  <li><b>Last Name</b>: "
	                + request.getParameter("last_name") + "\n" +
	                "</ul>\n" +
	                "</body></html>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("In the destroy Method");
	}
}