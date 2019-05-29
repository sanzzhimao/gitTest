package day01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IPLogServlet1
 */
@WebServlet(
		urlPatterns = { "/iplog1" }, 
		initParams = { 
				@WebInitParam(name = "fileName", value = "d:\\ip1.log")
		},
		displayName="iplog1",
		name="ipLogServlet1",
		loadOnStartup=0,
		asyncSupported=true
		)
public class IPLogServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//记录客户端ip
				//response.setContentType("text/html;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				PrintWriter pw=response.getWriter();
				String clientIP=request.getRemoteAddr();
				String fileName=getServletConfig().getInitParameter("fileName");
				PrintWriter logger=new PrintWriter(new FileOutputStream(fileName,true));
				//synchronized(logger){
					logger.print(new Date());
					logger.print(":");
					logger.println(clientIP);
					logger.flush();
					logger.close();
				//}
				pw.println("<!DOCTYPE html>");
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<meta charset=\"UTF-8\">");
				pw.println("<title>iplog</title>");
				pw.println("</head>");
				pw.println("<body>");
				pw.println("<h2 align=\"center\">你的信息已经被记录在服务器上"+getServletConfig().getInitParameter("fileName")+"文件中</h2>");
				pw.println("</body>");
				pw.println("</html>");
				pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
