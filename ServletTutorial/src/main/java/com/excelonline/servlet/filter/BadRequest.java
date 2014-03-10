package com.excelonline.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(description = "BadRequest", urlPatterns = { "/BadRequest"})
public class BadRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message = "";
	
	public BadRequest() {
		message = "BadRequest ";
		
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
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>Bad Request Filter Page</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1>Request Should be only from Jayram !!! but got it from ..."+
	                isAuthenticatedList+
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