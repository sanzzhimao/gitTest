package day01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrentTimeServlet2
 */
@WebServlet("/CurrentTimeServlet2")
public class CurrentTimeServlet2 extends HttpServlet {
	
    public CurrentTimeServlet2() {
       System.out.println("CurrentTimeServlet()2....");
       
    }
    public void doGet(HttpServletRequest req,
    	HttpServletResponse resp) throws IOException {
    	System.out.println("CurrentTimeServlet service2");
    	PrintWriter pw=resp.getWriter();
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
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
    	System.out.println("CurrentTimeServlet2 post req");
    	doGet(req,resp);
    }
}
