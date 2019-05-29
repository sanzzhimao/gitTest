package com.neusoft.ums.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ums.entity.User;
import com.neusoft.ums.service.IUserService;
import com.neusoft.ums.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/ums/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		IUserService ss=new UserService();
		User user=null;
		try {
			user = ss.userLogin(userName, userPass);
			HttpSession session=request.getSession(true);
			session.setAttribute("loginUser", user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null){
			response.sendRedirect("user/list");
		}else{
			response.sendRedirect(request.getContextPath()+"/ums/userLogin.html");
		}
	}

}
