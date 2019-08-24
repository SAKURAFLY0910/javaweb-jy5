package com.itdr.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

/**
 * ClassName: ${NAME}
 * 日期: 2019/8/9 7:21
 *
 * @author Air张
 * @since JDK 1.8
 */
@WebServlet("/sw")
@MultipartConfig
public class Servletw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

//获取上传的文件
            Part part = request.getPart("upimg");
//获取请求的信息
            String name = part.getHeader("content-disposition");
            System.out.println(name);//测试使用

            String rnp = request.getParameter("inp");
            System.out.println(rnp);

//获取上传文件的目录
//            String root = request.getServletContext().getRealPath("/images");
            String root = "E:\\zhangxin\\develop\\javaweb-jy5\\itdr_jy5_rgl\\rlgdemo\\web\\images\\products";
//            String root ="\\images\\products";
            System.out.println("测试上传文件的路径：" + root);

//获取文件的后缀
            String str = name.substring(name.lastIndexOf("."), name.length() - 1);
            System.out.println("测试获取文件的后缀：" + str);

//生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
            String filename = root + "\\" + UUID.randomUUID().toString() + str;
            System.out.println("测试产生新的文件名：" + filename);

//上传文件到指定目录，不想上传文件就不调用这个
            part.write(filename);

            response.getWriter().write("成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("失败");
        }
    }
}
