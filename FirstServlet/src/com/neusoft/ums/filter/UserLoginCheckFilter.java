package com.neusoft.ums.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.ums.entity.User;

/**
 * Servlet Filter implementation class UserLoginCheckFilter
 */
@WebFilter("/ums/user/*")
public class UserLoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserLoginCheckFilter() {
       
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("UserLoginCheckFilter execute....");
		HttpServletRequest res=(HttpServletRequest)request;
		HttpSession session=res.getSession();
		User loginUser=(User)session.getAttribute("loginUser");
		if(loginUser!=null){//说明已经登录了
			chain.doFilter(res, response);
		}else{
			session.setAttribute("message", "对不起，你没有登录，请登录");
			((HttpServletResponse)response).sendRedirect(res.getContextPath()+"/ums/userLogin.html");
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
