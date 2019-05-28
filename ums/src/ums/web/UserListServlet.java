package ums.web;

import ums.entity.User;
import ums.service.IUserService;
import ums.service.UserService;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/user/userlist")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        HttpSession session=request.getSession();
//        User user=(User) session.getAttribute("loginUser");
//        if (user!=null){
            //登录成功
            IUserService us=new UserService();
            List<User> users=null;
            //接收参数-页码和每页显示量
            String pageStr=request.getParameter("page");
            String pagesizeStr=request.getParameter("pagesize");

            int pageNum=0;

            if (pageStr==null){
                pageStr="1";
            }
            if (pagesizeStr==null){
                pagesizeStr="3";
            }
            int page=Integer.parseInt(pageStr);
            int pagesize=Integer.parseInt(pagesizeStr);
            try {
                /*users=us.broseAllUsers();*/
                users=us.brosepageUsers(page,pagesize);
                pageNum=us.getPageNum(pagesize);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //请求转发前，把数据(属性)保存在请求中,设置在请求范围,内部转发已经在相对路径下
//        request.setAttribute("users",users);
//        RequestDispatcher rd=request.getRequestDispatcher("viewusers");
//        rd.forward(request,response);
            //如果使用重定向，因为回产生新的请求，所以不能再把数据保存在请求中-保存在会话中
            session.setAttribute("users",users);
            session.setAttribute("pageNum",pageNum);
            session.setAttribute("page",page);
            session.setAttribute("pagesize",pagesize);
//            response.sendRedirect("viewusers");
            response.sendRedirect(request.getContextPath()+"/user/userlist.jsp");
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
