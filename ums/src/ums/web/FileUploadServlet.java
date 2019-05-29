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
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** 用户注册servlet
 * @author cro
 */
@WebServlet(name = "UserRegisterServlet",urlPatterns = "/register2")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String savePath= request.getServletContext().getRealPath("\\user\\images\\");
//        Part part1=request.getPart("singlefile");
//        String filename=part1.getHeader("content-disposition");
//        String fname=setFileName(filename);
//        System.out.println(part1.getName());
//        System.out.println(part1.getHeaderNames());
//        System.out.println(filename);
//        System.out.println("E:\\my documents\\documents\\IDEAPROJECTS\\javaweb\\ums\\web\\user\\images"+File.separator+fname);
//
//        part1.write("E:\\my documents\\documents\\IDEAPROJECTS\\javaweb\\ums\\web\\user\\images"+File.separator+fname);

        Collection<Part> part3=request.getParts();

        for (Part p:part3){
            String filename=p.getHeader("content-disposition");
            String pSub=filename.substring(filename.lastIndexOf("=")+2, filename.length()-1);
            if (pSub.indexOf(".")!=-1){
                String fname=setFileName(filename);
                p.write("E:\\my documents\\documents\\IDEAPROJECTS\\javaweb\\ums\\web\\user\\images"+File.separator+fname);
            }
        }




        Part part2=request.getPart("text");
        System.out.println(part2.getName());
        System.out.println(part2.getHeader("content-disposition"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public String setFileName(String filename){
        String[] fileStr=filename.split(";");
        String filenameStr=fileStr[2];
        String filenameStr2=filenameStr.substring(filenameStr.indexOf("."));
        String fname=filenameStr2.replace("\"","");
        fname=System.currentTimeMillis()+fname;
        System.out.println(fname);
        return fname;
    }

}
