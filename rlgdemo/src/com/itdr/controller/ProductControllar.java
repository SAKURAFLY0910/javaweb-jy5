package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.service.ProductService;
import com.itdr.service.UserService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.pathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( "/manage/product/*")
public class ProductControllar extends HttpServlet {
    //创建统一返回值对象
      ResponseCode rs = new ResponseCode();
//    private ProductControllar uc = new ProductControllar();
    private  ProductService ps=new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo=request.getPathInfo();
        String path= pathUTil.getpath(pathInfo);
        ResponseCode rs=null;

        switch (path){
            case "list":
              rs=  getAll(request,response);
//                response.getWriter().write(rs.toString());
            break;
            case "search"://查找
                rs=searchDo(request);
//                response.getWriter().write(rs.toString());
                break;
            case "detail"://详情
                rs=detailDo(request);
//                response.getWriter().write(rs.toString());
                break;
            case "set_sale_status"://上下架
                rs=set_sale_statusDo(request);
                break;
            case "save"://商品增加
                rs=saveDo(request);
                break;
        }
        response.getWriter().write(rs.toString());
    }
//新增商品
    private ResponseCode saveDo(HttpServletRequest request) {
        //获取session登录状态
        HttpSession session = request.getSession();
        //查看是否登录如果已经登录赋值给Users
        Users user = (Users)session.getAttribute("user");
        if( user == null){
            rs.setStatus(3);
            rs.setData("请登录后操作");
        }

        String pname = request.getParameter("pname");
        String categoryId = request.getParameter("categoryId");
        String subtitle = request.getParameter("subtitle");
        String imageHost = request.getParameter("imageHost");
        String price = request.getParameter("price");
        String status = request.getParameter("status");

        rs=ps.saveDo(pname,categoryId,subtitle,imageHost,price,status);
        return rs;

    }

    //产品上下架
    private ResponseCode set_sale_statusDo(HttpServletRequest request) {
        //获取session登录状态
        HttpSession session = request.getSession();
        //查看是否登录如果已经登录赋值给Users
        Users user = (Users)session.getAttribute("user");

        if( user == null){
            rs.setStatus(3);
            rs.setData("请登录后操作");
        }

        String productId = request.getParameter("productId");
        String status = request.getParameter("status");

        rs = ps.set_sale_statusDo(productId,status);
        return rs;
    }

    //产品详情
    private ResponseCode detailDo(HttpServletRequest request) {
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

        String det = request.getParameter("det");
        rs = ps.detailDo(det);
        return rs;
    }

    //搜索商品
    private ResponseCode searchDo(HttpServletRequest request) {
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

        String src = request.getParameter("src");

        System.out.println(src);
        rs = ps.searchDo(src);
        return rs;
    }

    //查询所有商品列表
    private ResponseCode getAll(HttpServletRequest request,HttpServletResponse response) {

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

        rs = ps.selectAll(pageNum,pageSize);

        return rs;
    }
}
