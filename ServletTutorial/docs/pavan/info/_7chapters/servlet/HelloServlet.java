package info._7chapters.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns={"/HelloServlet","/HS","/hello"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        System.out.println("HelloServlet.HelloServlet()");
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	System.out.println("HelloServlet.init()....");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    }
    
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response)
//    		throws ServletException, IOException {
//    	// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		
//		String name = request.getParameter("name");
//		String place = request.getParameter("place");
//		
//		out.println("Hello World Servlet" + new Date());
//		out.println("<br> Name is : "+ name +" Place is :"+place);
//    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		System.out.println("HelloServlet.doPost()"+ request.getParameterNames());
		
		Enumeration enume = request.getParameterNames();

		while(enume.hasMoreElements()){
			String enValue = (String)enume.nextElement();
			System.out.println("HelloServlet.doPost()...." + request.getParameter(enValue));
			
		}
		
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		
		out.println("Hello World Servlet" + new Date());
		out.println("<br> Name is : "+ name +" Place is :"+place);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("HelloServlet.destroy()");
	}
}
