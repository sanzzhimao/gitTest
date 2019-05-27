package ums.web;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import ums.entity.User;
import ums.service.IUserService;
import ums.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;


@WebServlet(name = "zuheFindServlet",urlPatterns = "/findservlet")
public class zuheFindServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("zuhe init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService us=new UserService();
        String userName=request.getParameter("userName");
        String birthday=request.getParameter("birthday");
        String hobbies=request.getParameter("hobbies");
        String pageStr=request.getParameter("page");
        String pagesizeStr=request.getParameter("pagesize");

        if (pageStr==null){
            pageStr="1";
        }
        if (pagesizeStr==null){
            pagesizeStr="3";
        }
        int page=Integer.parseInt(pageStr);
        int pagesize=Integer.parseInt(pagesizeStr);


        User user=new User();
        if (userName.length()!=0 && userName!=null){
            user.setUserName(userName);
        }
        if (birthday.length()!=0 && birthday!=null){
            Date bitrh=Date.valueOf(birthday);
            user.setBirthday(bitrh);
        }
        if (hobbies.length()!=0 && hobbies!=null){
            user.setHobbies(hobbies);
        }
        try {
            List users=us.broseProperUsers(user,page,pagesize);
            int pagenum=us.getSelectPageNum(user,pagesize);
            users.add(pagenum);
            /*输出给html ajax json*/
            ObjectMapper mapper=new ObjectMapper();
            //修改日期不被jackson转换为时间戳
            SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            mapper.setDateFormat(myDateFormat);

            String usersjson=mapper.writeValueAsString(users);

            PrintWriter pw=response.getWriter();
            pw.println(usersjson);

            System.out.println(usersjson);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    /** 将接收到的数据封装成user对象返回
     * @param request 请求
     * @return 返回封装的user对象
     */
    private User recivedDataToUser(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String userpass=request.getParameter("userpass");
        String birthdayStr=request.getParameter("birthday");
        String[] hobbies=request.getParameterValues("hobbies");
        System.out.println(username+userpass+birthdayStr);
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<hobbies.length;i++){
            sb.append(hobbies[i]);
            if(i!=hobbies.length-1){
                sb.append(",");
            }
        }
        String hobbiesStr=sb.toString();
        User user=new User();
        user.setUserName(username);
        user.setUserPass(userpass);
        user.setBirthday(Date.valueOf(birthdayStr));
        user.setHobbies(hobbiesStr);
        //把信息写到Cookie中
        Cookie usernameCookie=new Cookie("username",username);
        Cookie userpassCookie=new Cookie("userpass",userpass);
        Cookie birthdayCookie=new Cookie("birthday",birthdayStr);
//        Cookie hobbiesCookie=new Cookie("hobbies",hobbiesStr);
        //把Cookie发送到客户端
        response.addCookie(usernameCookie);
        response.addCookie(userpassCookie);
        response.addCookie(birthdayCookie);
//        response.addCookie(hobbiesCookie);
        return user;
    }
}
