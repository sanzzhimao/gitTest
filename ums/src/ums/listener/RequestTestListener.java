package ums.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Enumeration;

/**
 * @author cro
 * ServletRequestListener-监听请求创建和销毁
 * ServletRequestAttributeListener-监听请求作用域数据更改
 */

public class RequestTestListener implements ServletRequestListener,ServletRequestAttributeListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest sr=sre.getServletRequest();
        Enumeration attributeNames=sr.getAttributeNames();

        System.out.println("request创建");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent arae) {
        System.out.println("请求作用域中新增了一条数据"+arae.getName()+arae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent arae) {
        System.out.println("请求作用域中删除了一条数据"+arae.getName()+arae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent arae) {

    }

}
