package ums.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ViewSuccessServlet",urlPatterns = "/regsuccess")
public class ViewSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        //所有Servlet都能拿到
        ServletContext sc=getServletContext();
        //拿到初始化参数名未email的值
        String email=sc.getInitParameter("email");
        System.out.println(sc.getContextPath());
        System.out.println(sc.getRealPath("/ums/register"));

        PrintWriter pw=response.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<title>success</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h3>注册成功,联系方式："+email+"</h3>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}
