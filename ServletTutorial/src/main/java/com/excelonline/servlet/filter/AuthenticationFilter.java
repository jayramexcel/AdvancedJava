package com.excelonline.servlet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName="AuthenticationFilter" , urlPatterns={"/*"},initParams={
		@WebInitParam(name="dbName",value="Oracle")
		})
public class AuthenticationFilter implements Filter {
	private static Logger log = Logger.getLogger(AuthenticationFilter.class);

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		log.info("Destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String ipAddress = request.getRemoteAddr();
		log.info("IP "+ ipAddress + ", Time "
                + new Date().toString());
		String name = request.getParameter("first_name");
		System.out.println("AuthenticationFilter.doFilter()-----" + name);
		List list = new ArrayList();
		
		if("Jayram".equals(name)) {
			list.add(name+"Good");
			request.setAttribute("isAuthenticated", list);
		}else {
			list.add(name+"Bad");
			request.setAttribute("isAuthenticated", list);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String testParam = fConfig.getInitParameter("dbName"); 
		log.info("Test Param in AutFilter.......: " + testParam); 
	}
}