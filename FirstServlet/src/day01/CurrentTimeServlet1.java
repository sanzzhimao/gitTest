package day01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class CurrentTimeServlet1
 */
@WebServlet("/CurrentTimeServlet1")
public class CurrentTimeServlet1 extends GenericServlet {
	
    public CurrentTimeServlet1() {
        System.out.println("CurrentTimeServlet1()..."); 
    }

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("CurrentTimeServlet servce1");
		PrintWriter pw=arg1.getWriter();
		pw.println("<DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>insert title here</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>currenttime:"+new Date()+"</h1>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

}
