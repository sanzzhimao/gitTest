package day01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Currentdate1")

public class CurrentTimeServlet implements Servlet {
	
	private ServletConfig sc;
	public CurrentTimeServlet(){
		System.out.println("CurrentTimeServlet()....");
	}
	@Override
	public void destroy() {
		System.out.println("CurrentTimeSevlet destory");

	}
	
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("CurrentTimeSevlet getServletConfig");
		return sc;
	}

	@Override
	public String getServletInfo() {
		System.out.println("CurrentTimeSevlet getServletInfo");
		return this.getClass().getName();
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("CurrentTimeSevlet init");
		this.sc=arg0;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("CurrentTimeSevlet service");
		PrintWriter pw=arg1.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Insert title here</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>currenttime:"+new Date()+"</h1>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

}
