package ums.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterHtmlServlet",urlPatterns = "/registerhtml")
public class RegisterHtmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        PrintWriter pw=response.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html lang=\"en\">");
        pw.println("<head>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<title>register</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>User Manage System Signin</h1>");
        pw.println("<hr>");
        pw.println("<form action=\"/ums/register\" method=\"post\">");
        pw.println("username:<input type=\"text\" name=\"username\" value=\""+getCookieByName(request,"username")+"\">");
        pw.println("password:<input type=\"password\" name=\"userpass\" value=\""+getCookieByName(request,"userpass")+"\">");
        pw.println("birthday:<input type=\"date\" name=\"birthday\" value=\""+getCookieByName(request,"birthday")+"\">");
        pw.println("hobbies：<input type=\"checkbox\" name=\"hobbies\" value=\"r\"/>阅读");
        pw.println("        <input type=\"checkbox\" name=\"hobbies\" value=\"s\"/>游泳");
        pw.println("        <input type=\"checkbox\" name=\"hobbies\" value=\"m\"/>音乐");
        pw.println("        <input type=\"checkbox\" name=\"hobbies\" value=\"g\"/>游戏");
        pw.println("        <input type=\"submit\" value=\"submit\"/>");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /** 通过cookie名称获取cookie
     * @param request 请求
     * @param name 需要获取的cookie名
     * @return cookie值
     */
    private String getCookieByName(HttpServletRequest request,String name){
        String value=null;
        //通过请求获得所有cookie
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            for (int i=0;i<cookies.length;i++){
                if (cookies[i].getName().equals(name)){
                    value=cookies[i].getValue();
                    break;
                }
            }
        }
        return value;
    }
}
