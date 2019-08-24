package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.pathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/manage/user/*")
//list.do
public class UsersController extends HttpServlet {
    private UserService uc = new UserService();

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
//     判断是什么样的请求
        switch (path) {
            case "list":
                rs=listDo(request, response);
                break;
            case "login":
                rs=loginDo(request, response);
                break;
            case "disableuser":
               rs=disableuserDo(request);
                break;
            case "yz":
                yzDo(request, response);
                break;
            case "super":
                rs=superDo(request, response);
                break;
        }
//      返回响应数据
            response.getWriter().write(rs.toString());

//        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(JsonUtils.obj2String(rs));
    }
//超级管理员
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

        rs = uc.superDo(pageSize, pageNum);
        //调用业务层处理业
        return rs;

    }

    // 获取所用用户列表的请求
    private ResponseCode listDo(HttpServletRequest request, HttpServletResponse response) {

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

        rs = uc.selectAll(pageSize, pageNum);
        //调用业务层处理业
          return rs;
    }

    //   用户登录的请求
    private ResponseCode loginDo(HttpServletRequest request,HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResponseCode rs = uc.selectOne(username, password);
//              System.out.println(rs);
        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("user", rs.getData());
        //调用业务层处理业务
        return  rs;
    }

    //    禁用用户的请求
    private ResponseCode disableuserDo(HttpServletRequest request) {

        String uid = request.getParameter("uid");

        ResponseCode rs = uc.selectOne(uid);

        //调用业务层处理业务
        return rs;
    }

    //验证用户名是否存在
    private void yzDo(HttpServletRequest request, HttpServletResponse response) {

        String uname = request.getParameter("un");
        Boolean bol = uc.yz(uname);

        //调用业务层处理业务
        try {
            response.getWriter().write(bol + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

