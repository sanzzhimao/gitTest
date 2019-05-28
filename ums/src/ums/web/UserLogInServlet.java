package ums.web;

import ums.entity.User;
import ums.service.IUserService;
import ums.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ASUS
 */
@WebServlet(name = "UserLogInServlet",urlPatterns = "/login")
public class UserLogInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String userpass=request.getParameter("userPass");
        IUserService us=new UserService();
        try {
            User user=us.userLogin(userName,userpass);
            HttpSession session=request.getSession(true);
            if (user!=null){
                session.setAttribute("loginUser",user);
                session.setAttribute("loginUserName",userName);
                response.sendRedirect("user/userlist");
            }else{
                response.sendRedirect("/ums/login.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
