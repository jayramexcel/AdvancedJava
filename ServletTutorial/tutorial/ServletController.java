package info._7chapters.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/controller")

public class ServletController extends HttpServlet{
	private static Logger log = Logger.getLogger(HelloWorldServlet.class);
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String toDo = req.getParameter("toDo");
		String name = req.getParameter("name");
		
		if("a".equals(toDo)){
			RequestDispatcher rd = req.getRequestDispatcher("add");
			rd.forward(req,resp);
		}else if("s".equals(toDo)){
			RequestDispatcher rd = req.getRequestDispatcher("sub");
			rd.forward(req,resp);
		}else{
			resp.sendRedirect("guys?fname="+name);
		}
	}
}