package com.itdr.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletdemo1" ,value ="/aaaa" )
public class Servletdemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String w11="陶勇";
        String w12="123456";
        String w13="克苏鲁";

        String w1=request.getParameter("w1");
        String w2=request.getParameter("w2");
        String w3=request.getParameter("w3");
        int count=0;

        if (w11.equals(w1)) {
            count++;
            if (w12.equals(w2)) {
                count++;
                if (w13.equals(w3)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
