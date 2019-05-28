package ums.filter;

import com.sun.deploy.net.HttpRequest;
import ums.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/user/*")
public class LogInCheckFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("验证登录filter");
        HttpServletRequest request=(HttpServletRequest) req;
        HttpSession session=request.getSession();
        User loginUser=(User) session.getAttribute("loginUser");
        if (loginUser!=null){
            //已经登录,允许往后执行，过滤链往后调用
            chain.doFilter(req, resp);
        }else {
            //未登录，回到登录页面
            session.setAttribute("message","not login yet");
            ((HttpServletResponse) resp).sendRedirect(request.getContextPath()+"/login.html");
        }


    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
