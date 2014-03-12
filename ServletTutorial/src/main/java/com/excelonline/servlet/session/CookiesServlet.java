package com.excelonline.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(name="CookiesServlet" ,description = "My Hello World", urlPatterns = { "/hiCookie" })
public class CookiesServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(CookiesServlet.class);
	private static final long serialVersionUID = 1L;
	String message = "";

	public CookiesServlet() {
		message = "Hello Cookies World";
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
//		HttpSession session = request.getSession();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		System.out.println("First Name "+ fname);
		
		PrintWriter out = response.getWriter();
		
		Cookie [] cooki = request.getCookies();
		System.out.println("CookiesServlet.doGet()" + cooki);
		if(cooki !=null){
			for(Cookie cook : cooki){
				if("Divya".equals(fname)){
					if ("myUniquieID".equals(cook.getName()) && "123456".equals(cook.getValue())) {
						out.println("<h1>Hi Divya How are u....Existing </h1>");
					}else {
						Cookie cookie = new Cookie("myUniquieID123456","123456");
						response.addCookie(cookie);
						out.println("<h1>This is a new Client...</h1>");
					}
				}else if("Jayram".equals(fname)){
					if ("myUniquieID".equals(cook.getName()) && "98765".equals(cook.getValue())) {
						out.println("<h1>Hi Jayram How are u....</h1>");
					}else {
						Cookie cookie = new Cookie("myUniquieID98765","98765");
						response.addCookie(cookie);
						out.println("<h1>This is a new Client...</h1>");
					}
				}
				log.info("Return value from Cookies "+ cook.getName() +" cook value "+ cook.getValue());
			}
		}else{
			String value = "";
			if("Divya".equals(fname)){
				value = "123456";
			}else {
				value = "98765";
			}
			Cookie cookie = new Cookie("myUniquieID"+value,value);
			response.addCookie(cookie);
			out.println("<h1>This is a new Client...</h1>");
		}
		
		out.println("<h1>" + message + "</h1>");
		out.println("<h1>" + fname + " "+ lname+ "</h1>");
		out.println("<h1>Welcome !!!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		doGet(request, response);
	}
}