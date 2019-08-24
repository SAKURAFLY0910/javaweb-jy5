package com.itdr.Demo2;


import com.itdr.Demo2.mapper.OrderMapper;
import com.itdr.pojo.Order;
import org.apache.ibatis.session.SqlSession;
import utils.GetSqlSessionUtils;

import java.util.ArrayList;
import java.util.List;


public class TestDemo {
    public static void main(String[] args) {

           selects();//查询
//           updates(2,5);//
//           adds(0,"3c11bb51-716e-4b5e-bec7-2249ea2a7f3b",52);
//           det(7);
//           check(null,"素书");
//             checks(1,2,3);
    }

    //查询
    public static void selects(){
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> all = mapper.getAll();
        for (Order order : all) {
            System.out.println(order.getOrderNo());
            System.out.println(order.getProductName());
        }
    }
//修改
    public static  void updates(Integer status,Integer id){
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        int updates = mapper.updates(status, id);
        System.out.println(updates);

    }

//增加
    public static  void adds(Integer status,String orderNo,Integer payment){
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        int adds = mapper.adds(status, orderNo, payment);
        System.out.println(adds);

    }
//删除
    public static  void det(Integer id){
    SqlSession sqlSession = GetSqlSessionUtils.getOne();
    OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
    sqlSession.commit();
    int det = mapper.det(id);
    System.out.println(det);
}
//两个
public static void check(Integer id,String productName ) {
    SqlSession sqlSession = GetSqlSessionUtils.getOne();
    OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
    Order check = mapper.check(id, productName);
    System.out.println(check.getOrderNo());
}
//123
    public static void checks(Integer a,Integer b,Integer c) {
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Integer> s=new ArrayList();
        s.add(a);
        s.add(b);
        s.add(c);
        List<Order> checks = mapper.checks(s);
        for (Order check : checks) {
            System.out.println(check.getOrderNo());
        }
    }

}