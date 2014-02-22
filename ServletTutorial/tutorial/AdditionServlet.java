package info._7chapters.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/add")

public class AdditionServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(HelloWorldServlet.class);
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String fnum = req.getParameter("fnum");
		String snum = req.getParameter("snum");
		
		PrintWriter out = resp.getWriter();
		int finalValue = Integer.parseInt(fnum) + Integer.parseInt(snum);
		out.println("Final Addition Value is "+ finalValue);
	}
}