package ums.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ums.entity.User;
import ums.service.IUserService;
import ums.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/** 用户注册servlet
 * @author cro
 */
@WebServlet(name = "UserRegisterServlet",urlPatterns = "/register2")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String savePath= request.getServletContext().getRealPath("/WEB-INF/");
        Part part1=request.getPart("file");
        System.out.println(part1.getName());
        System.out.println(part1.getHeaderNames());
        Part part2=request.getPart("text");
        System.out.println(part2.getName());
        System.out.println(part2.getHeaderNames());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
