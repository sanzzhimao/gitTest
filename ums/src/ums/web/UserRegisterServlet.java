package ums.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ums.entity.User;
import ums.service.IUserService;
import ums.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** 用户注册servlet
 * @author cro
 */
@WebServlet(name = "UserRegisterServlet",urlPatterns = "/register")
public class UserRegisterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("register init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        ServletConfig config=getServletConfig();
//        ServletContext sc=config.getServletContext();
//        //获取Context的名字
//        System.out.println(sc.getServletContextName());
//        //获取请求方式
//        System.out.println(request.getMethod());
//        //获取上下文路径
//        System.out.println(request.getContextPath());
//        //通过请求获取协议
//        System.out.println(request.getProtocol());
//        //获取servlet应用路径
//        System.out.println(request.getServletPath());
//        //获取主机-头字段
//        System.out.println(request.getHeader("host"));
//        String servletname=sc.getServletContextName();
//        System.out.println(servletname);
        /*上下文参数和servlet参数不同，上下文参数在当前应用下，在webxml中context-para中设置*/
        /*设置请求的编码为utf8，请求发来的数据若为中文会造成乱码*/
//        request.setCharacterEncoding("utf8");
//        response.setCharacterEncoding("utf-8");
//        User user=recivedDataToUser(request,response);
        IUserService us=new UserService();
        try {
            User user=picUpload(request);
            //注册用户
            us.registerUser(user);
            /*请求转发与重定向问题
             *   请求转发，该请求不会发生改变，所以在跳转到了后面的页面之后，再刷新页面，服务端还是会收到最开始的请求
             *   会造成‘灌水’的问题
             *   重定向-客户端发送请求-服务端响应请求回客户端-客户端再发送新请求-服务端响应
             *   所以重定向会有两次请求，两次响应，不存在灌水问题
             */
            //成功重定向到成功界面
            response.sendRedirect("/ums/regsuccess");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/ums/regfailed");
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
    private User recivedDataToUser(HttpServletRequest request,HttpServletResponse response){

        String username=request.getParameter("username");
        String userpass=request.getParameter("userpass");
        String birthdayStr=request.getParameter("birthday");
        String[] hobbies=request.getParameterValues("hobbies");
        System.out.println(username+userpass+birthdayStr);
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<hobbies.length;i++){
            sb.append(hobbies[i]);
            if (i!=sb.length()-1){
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

    /**
     * @param request
     * @return
     */
    private User picUpload(HttpServletRequest request) throws Exception {
        String picLoc=null;
        String fpath=null;
        User user=new User();
        String username=null;
        String userpass=null;
        Date birthday=null;
        String fname=null;
        List<String> hobbies=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        boolean isMulttpart= ServletFileUpload.isMultipartContent(request);
        if (isMulttpart){
            //为真代表表单中有上传文件域
            DiskFileItemFactory dfif=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(dfif);
            //对头部的字符编码设置
            upload.setHeaderEncoding("utf8");
            //设置文件上传最大大小
            upload.setFileSizeMax(20*1024*1024);
            //解析请求,不管是不是文件上传域都会封装
            List<FileItem> fis=upload.parseRequest(request);
            //取出每个fileitem判断是不是文件上传域
            for (FileItem fi:fis){
                if (fi.isFormField()){
                    //普通表单控件
                    //接收表单控件的名字
                    String name=new String(fi.getFieldName());
                    //得到值
                    String value=new String(fi.getString());

                    //判断每个表单控件的名字-封装给user
                    if ("username".equals(name)){
                        username=value;
                    }
                    if ("userpass".equals(name)){
                        userpass=value;
                    }
                    if ("birthday".equals(name)){
                        Date date=Date.valueOf(value);
                        birthday=date;
                    }
                    if ("hobbies".equals(name)){
                        hobbies.add(value);
                    }
                    System.out.println(name+"-"+value);
                }else {
                    //非普通表单控件
                    String filename=fi.getName();
                    System.out.println("filename="+filename);
                    //文件名不为空且带后缀名
                    if (filename!=null && filename.indexOf(".")!=-1){
                        //日期的毫秒数+原扩展名(从.之后开始取)
                        fname=System.currentTimeMillis()+"."+filename.substring(filename.indexOf(".")+1);
                        fpath="E:\\my documents\\documents\\IDEAPROJECTS\\javaweb\\ums\\web\\user\\images\\"+fname;
//                        fpath=request.getServletContext().getRealPath("/images/pic")+fname;
                        System.out.println(fpath);
                        //当前应用上下文，真实地址，的image子文件下
                        File file=new File(fpath);
                        fi.write(file);
                    }
                    //删除临时文件
                    fi.delete();
                }
            }
            //把hobbies变成字符串
            for (int i=0;i<hobbies.size();i++){
                sb.append(hobbies.get(i));
                if (i!=sb.length()-1){
                    sb.append(",");
                }
            }
            String hobbiesStr=sb.toString();
            user.setUserName(username);
            user.setUserPass(userpass);
            user.setBirthday(birthday);
            user.setHobbies(hobbiesStr);
            user.setPic(fname);

        }
        return user;
    }
}
