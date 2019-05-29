package com.neusoft.ums.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UserListServlet
 */
@WebServlet("/ums/user/list")
public class UserListServlet extends HttpServlet {
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
//		//Ȩ����֤
		HttpSession session=request.getSession(false);
//		User user=(User)session.getAttribute("loginUser");
//		if(user!=null){//��¼�ɹ����Ѿ���¼
			IUserService ss=new UserService();
			List<User> users=null;
			try {
				users=ss.browseAllUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			//request.setAttribute("users",users);
//			System.out.println(session.getId());
//			System.out.println(session.getCreationTime());
			session.setAttribute("users",users);
			//����ת��
//			RequestDispatcher rd=request.getRequestDispatcher("viewusers");
//			rd.forward(request,response);
			//�ض���
			response.sendRedirect("viewusers");
//		}else{//��¼ʧ�ܻ�û��¼
//			session.setAttribute("message", "��û��¼���¼ʧ�ܣ����¼");
//			response.sendRedirect(request.getContextPath()+"/ums/userLogin.html");
//		}
	}
}
