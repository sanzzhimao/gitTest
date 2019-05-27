package ums.web;

import ums.service.IUserService;
import ums.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DelUsersServlet",urlPatterns = "/user/deluser")
public class DelUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] usernamesStr=request.getParameterValues("usernames");
        IUserService us=new UserService();
        try {
            us.delUsers(usernamesStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
