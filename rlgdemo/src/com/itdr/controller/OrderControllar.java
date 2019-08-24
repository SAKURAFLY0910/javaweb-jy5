package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.OrderService;
import com.itdr.service.ProductService;
import com.itdr.utils.pathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/manage/order/*")
public class OrderControllar extends HttpServlet {
    //创建统一返回值对象
    ResponseCode rs = new ResponseCode();
    private OrderService ps=new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo=request.getPathInfo();
        String path= pathUTil.getpath(pathInfo);
        ResponseCode rs=null;

        switch (path){
            case "detail"://详情
                rs=detailDo(request);
                break;
            case "search"://查找
                rs=searchDo(request);
//                response.getWriter().write(rs.toString());
                break;
            case "list"://列表
                rs=listDo(request);
                break;
            case "send_goods"://发货
                rs=send_goodsDo(request);
                break;

        }
        response.getWriter().write(rs.toString());
    }
//订单发货
    private ResponseCode send_goodsDo(HttpServletRequest request) {
//        String OR = request.getParameter("orderNo ");
        String OR = request.getParameter("orderNo");
        System.out.println(OR);

        ResponseCode rs= ps.send_goodsDo(OR);
        return rs;
    }

    //订单列表
    private ResponseCode listDo(HttpServletRequest request) {
         //获取session登录状态
        HttpSession session = request.getSession();
        //查看是否登录如果已经登录赋值给Users
        Users user = (Users)session.getAttribute("user");
        if( user == null){
            rs.setStatus(3);
            rs.setData("请登录后操作");
        }

        String pageSize = request.getParameter("paseSize");
        String pageNum = request.getParameter("pageNum");

        rs = ps.listDo(pageNum,pageSize);

        return rs;
    }

    //按订单查询号
    private ResponseCode searchDo(HttpServletRequest request) {
        //获取session登录状态
        HttpSession session = request.getSession();
        //查看是否登录如果已经登录赋值给Users
        Users user = (Users)session.getAttribute("user");

        if( user == null){
            rs.setStatus(3);
            rs.setData("请登录后操作");
        }

        String orderNo = request.getParameter("orderNo");

        rs = ps.searchDo(orderNo);
        return rs;

    }
//订单详情
    private ResponseCode detailDo(HttpServletRequest request) {
        //获取session登录状态
        HttpSession session = request.getSession();
        //查看是否登录如果已经登录赋值给Users
        Users user = (Users)session.getAttribute("user");

        if( user == null){
            rs.setStatus(3);
            rs.setData("请登录后操作");
        }
        String orderNo = request.getParameter("orderNo");
        rs = ps.detailDo(orderNo);
        return rs;
    }
}
