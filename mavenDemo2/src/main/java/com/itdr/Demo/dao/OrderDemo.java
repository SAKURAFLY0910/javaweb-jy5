package com.itdr.Demo.dao;

import com.itdr.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class OrderDemo implements  OrderDao{
    @Override
    public Order getNew(Integer id) {

        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
// 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
// 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
// 执行Sql语句,接口中的方法名
        Order us = sqlSession.selectOne("getNew", id);
        return us;
    }
}
