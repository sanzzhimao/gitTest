package ums.web;

import ums.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/viewusers")
public class ViewUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        //session为空会创建一个，但是loginuser为空
        HttpSession session=request.getSession();
//        User loginUser=(User)session.getAttribute("loginUser");
//        if (loginUser!=null){

            //获得的是Object，需要转换
//        List<User> users=(List)request.getAttribute("users");
            List<User> users=(List)session.getAttribute("users");
            PrintWriter pw=response.getWriter();
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset=\"UTF-8\">");
            pw.println("<title>用户信息浏览</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1 align=\"center\">用户管理系统</h1>");
            pw.println("<hr/>");
            if (users==null){
                pw.println("<p>没有用户数据</p>");
            }
            else{
                pw.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\" align=\"center\">");
                pw.println("<thead>");
                pw.println("<tr>");
                pw.println("<th>序号</th><th>姓名</th><th>出生日期</th><th>爱好</th>");
                pw.println("</tr>");
                pw.println("</thead>");
                pw.println("<tbody>");
                for (int i=0;i<users.size();i++){
                    User user=users.get(i);
                    pw.println("<tr align=\"center\">");
                    pw.println("<td>"+(i+1)+"</td><td>"+user.getUserName()+"</td><td>"+user.getBirthday()+"</td><td>"+user.getHobbies()+"</td>");
                    pw.println("</tr>");
                }
                pw.println("</tbody>");
                pw.println("</table>");

            }
            pw.println("</body>");
            pw.println("</html>");
            pw.close();
//        }else {
//            //登陆失败
//            response.sendRedirect("/ums/login.html");
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
