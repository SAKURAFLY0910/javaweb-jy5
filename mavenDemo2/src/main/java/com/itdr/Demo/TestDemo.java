package com.itdr.Demo;

import com.itdr.Demo.dao.OrderDao;
import com.itdr.Demo.dao.OrderDemo;
import com.itdr.pojo.Order;


public class TestDemo {
    public static void main(String[] args) {
        OrderDao pd=new OrderDemo();
        Order us= pd.getNew(3);
        System.out.println(us.getProductName());
    }
}