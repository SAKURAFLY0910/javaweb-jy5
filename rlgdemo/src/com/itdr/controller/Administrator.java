package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.AdministratorService;
import com.itdr.service.UserService;
import com.itdr.utils.pathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/manage/Administrator/super")
public class Administrator extends HttpServlet {
    private AdministratorService uc = new AdministratorService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

//        怎么获取请求路径
        String pathInfo = request.getPathInfo();

        String path = pathUTil.getpath(pathInfo);
//        System.out.println(path);
        ResponseCode rs = null;

        rs=superDo(request, response);

        response.getWriter().write(rs.toString());

    }

    private ResponseCode superDo(HttpServletRequest request, HttpServletResponse response) {
        ResponseCode rs = new ResponseCode();
        HttpSession session = request.getSession();

        Users user = (Users) session.getAttribute("user");
        if( user == null){
            rs.setStatus(3);
            rs.setData("请登录后操作");
        }



        //获取参数
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        String username = request.getParameter("username");

        rs = uc.superDo(pageSize, pageNum,username);
        //调用业务层处理业
        return rs;
    }
}
