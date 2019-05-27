/**
 * @program: javaweb
 * * @description: 当前时间 使用2.x配置
 * * @author:cro
 * * @create: 2019-05-16 10:39
 **/

package day01;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CurrentTime2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("currenttime2 init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("CurrentTimeSevlet2 service");
        PrintWriter pw=servletResponse.getWriter();
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

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory currenttime2");
    }
}
