package com.neusoft.ums.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.ums.entity.User;
import com.neusoft.ums.service.IUserService;
import com.neusoft.ums.service.UserService;
import com.neusoft.ums.util.StringUtil;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/ums/register")
public class UserRegisterServlet extends HttpServlet {
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
		//��ȡServletConfig����
		ServletConfig config=getServletConfig();
		ServletContext sc=config.getServletContext();
		String servletName=config.getServletName();
		System.out.println(sc);
		System.out.println(servletName);
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());
		System.out.println(request.getProtocol());
		System.out.println(request.getServletPath());
		System.out.println(request.getHeader("host"));
		System.out.println(request.getContentLength());
		System.out.println(request.getContentType());
		//�����������ݣ���װUser���� 
		User user=reciveDataToUser(request);
		try {
			//����ҵ���߼����ע��
			IUserService ss=new UserService();
			ss.registerUser(user);
			//�ж��Ƿ�ע��ɹ�
			//�ɹ�
			//����ת��
//			RequestDispatcher rd=request.getRequestDispatcher("viewsuccess");
//			rd.forward(request,response);
			//�ض���
			response.sendRedirect("viewsuccess");
		} catch (SQLException e) {
			e.printStackTrace();
			//ʧ��
			//����ת��
//			RequestDispatcher rd=request.getRequestDispatcher("viewfail");
//			rd.forward(request,response);
			//�ض���
			response.sendRedirect("viewfail");
		}
		
	}
	private User reciveDataToUser(HttpServletRequest request) throws UnsupportedEncodingException{
		
		//���������еĲ�������װΪ�û�����
		String userName=request.getParameter("username");
		String userPass=request.getParameter("userpass");
		String birthStr=request.getParameter("birthday");
		System.out.println(birthStr);
		String[] hobbies=request.getParameterValues("hobbies");
		String hobbiesStr=StringUtil.getStringJionWithDaoHao(hobbies);
		User user=new User();
		user.setUserName(userName);
		user.setUserPass(userPass);
		user.setBirthday(Date.valueOf(birthStr));//2019-05-14
		user.setHobbies(hobbiesStr);
		return user;
	}
}
