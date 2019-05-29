package com.neusoft.ums.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ums.entity.User;

/**
 * Servlet implementation class ViewUsersServlet
 */
@WebServlet("/ums/user/viewusers")
public class ViewUsersServlet extends HttpServlet {
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
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
		//权限验证
		HttpSession session=request.getSession();
		User loginUser=(User)session.getAttribute("loginUser");
//		if(loginUser!=null){//登录成功，已经登录
			//List<User> users=(List)request.getAttribute("users");
			List<User> users=(List)session.getAttribute("users");
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<meta charset=\"UTF-8\">");
			pw.println("<title>用户信息浏览</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("	<h1 align=\"center\">用户管理系统</h1>");
			pw.println("用户名:"+loginUser.getUserName());
			pw.println("	<hr/>");
			if(users==null){
				pw.println("<p>没有用户数据</p>");
			}else{
				pw.println("	<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\" align=\"center\">");
				pw.println("		<thead>");
				pw.println("			<tr>");
				pw.println("				<th>序号</th><th>姓名</th><th>出生日期</th><th>爱好</th>");
				pw.println("			</tr>");
				pw.println("		</thead>");
				pw.println("		<tbody>");
				for(int i=0;i<users.size();i++){
					User user=users.get(i);
					pw.println("			<tr align=\"center\">");
					pw.println("				<td>"+(i+1)+"</td><td>"+user.getUserName()+"</td><td>"+user.getBirthday()+"</td><td>"+user.getHobbies()+"</td>");
					pw.println("			</tr>");
				}
				pw.println("		</tbody>");
				pw.println("	</table>	");
			}
			pw.println("</body>");
			pw.println("</html>");
			pw.close();
	}
}
