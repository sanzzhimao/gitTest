package ums.web;

import ums.entity.User;
import ums.service.IUserService;
import ums.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "CheckUsernameServlet",urlPatterns = "/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService us=new UserService();
        String userName=request.getParameter("inputname");
        PrintWriter pw=response.getWriter();
        try {
            User userExist=us.checkUserName(userName);
            if (userExist==null){
                pw.println("可以注册该用户");
            }else {
                pw.println("用户名已存在");
            }
            pw.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
