package ums.listener;

import ums.entity.User;

import javax.jms.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.*;

/**
 * @author ASUS
 */
@WebListener()
public class SessionContextListener implements ServletContextAttributeListener,HttpSessionAttributeListener,HttpSessionListener,ServletContextListener {
    /**
     * session-数据变更
     * */
    @Override
    public void attributeAdded(HttpSessionBindingEvent hsbe) {
        String attributeName=hsbe.getName();
        System.out.println(attributeName);
        String username="loginUserName";
        if (username.equals(attributeName)){
            ServletContext sc=hsbe.getSession().getServletContext();
            String loginUserName=(String) hsbe.getSession().getAttribute("loginUserName");
            List infos=(List) sc.getAttribute("infos");
            String sessionId=hsbe.getSession().getId();
            Date date=new Date();
            String dateStr=String.valueOf(date);
            String sessionInfo="用户名:"+loginUserName+" sessionID:"+sessionId+" 创建时间:"+dateStr;
            System.out.println(sessionInfo);

            infos.add(sessionInfo);
            System.out.println(infos.size());
            sc.setAttribute("infos",infos);

        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent hsbe) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent hsbe) {


    }
    /**
     * 会话创建与销毁
     * */

    @Override
    public void sessionCreated(HttpSessionEvent hse) {

        //获取变量
        ServletContext sc=hse.getSession().getServletContext();
        int onlineUsers=(Integer) sc.getAttribute("onlineUsers");
        //加一
        sc.setAttribute("onlineUsers",++onlineUsers);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        System.out.println("session销毁"+hse.getSession().getId());
        ServletContext sc=hse.getSession().getServletContext();
        int onlineUsers=(Integer) sc.getAttribute("onlineUsers");
        sc.setAttribute("onlineUsers",--onlineUsers);
        /*删除这个用户的在线信息*/
        List infos=(List) sc.getAttribute("infos");

    }
    /**
     * 应用上下文属性监听
     * */
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {

    }
    /**
     * 应用上下文创建、销毁
     * */

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("session创建");
        //获取应用上下文
        ServletContext sc=sce.getServletContext();
        //存储在线人数
        sc.setAttribute("onlineUsers",0);
        List infos=new ArrayList();
        sc.setAttribute("infos",infos);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("session销毁");
    }
}
