package com.itdr.Demo2.mapper;

import com.itdr.Demo.dao.OrderDao;
import com.itdr.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.GetSqlSessionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrderDemo implements  OrderMapper{

    @Override
    public List<Order> getAll() {
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        List<Order> All = sqlSession.selectList("getAll");
        return All;
    }

    @Override
    public int updates(Integer status, Integer id) {
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        Order rt=new Order();
        rt.setStatus(status);
        rt.setId(id);
        int updates = sqlSession.update("updates", rt);
        return  updates;
    }

    @Override
    public int adds(Integer status,String orderNo,Integer payment) {
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        Order rt=new Order();
        rt.setStatus(status);
        rt.setOrderNo(orderNo);
        rt.setPayment(payment);
//        sqlSession.commit();
        int adds = sqlSession.insert("adds", rt);
        return adds;

    }

    @Override
    public int det(Integer id) {
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        int det = sqlSession.delete("det",id);
        return det;

    }

    @Override
    public Order check(Integer id, String productName) {
        return null;
    }

    @Override
    public List<Order> checks(List<Integer> lis) {
        return null;
    }


}
