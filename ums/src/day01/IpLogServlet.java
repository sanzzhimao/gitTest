package day01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/** 记录ip地址到本地文件
 * @author cro
 * 2019-5-16
 */
@WebServlet(name = "IpLogServlet",urlPatterns = "/iplog")
public class IpLogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应字符集
        response.setCharacterEncoding("utf8");
        //输出到客户端
        PrintWriter pw=response.getWriter();
        String filename="E:\\my documents\\documents\\IDEAPROJECTS\\javaweb\\ums\\src\\day01\\iplog.log";
        //准备一个输出流,写出到文件
        Date date=new Date();
        PrintWriter logger=new PrintWriter(new FileOutputStream(filename),true);
        logger.print(date);
        logger.print(":");
        logger.print(request.getRemoteAddr());
        //关闭文件流
        logger.flush();
        logger.close();
        //发送信息到客户端
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<title>ip-log</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>你的信息记录在服务器上，文件；"+filename+"</h1>");
        pw.println("</body>");
        pw.println("</html>");
        //关闭网络输出流
        pw.close();
    }
}
