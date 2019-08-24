package com.itdr.dao;

import com.itdr.pojo.Order;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
//订单详情
    public Order detailDo(String orderNo) {
        //调用连接池方法
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = " select *from `order` where orderNo=?";

        Order li=null;
//        System.out.println(1536894);
        try {
            li = qr.query(sql, new BeanHandler<Order>(Order.class),orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;

    }
//订单列表
    public  List<Order>  listDo(String pageNum, String pageSize) {
        //调用连接池方法
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());
        String sql = "select * from `order`";
        List<Order> li = null;

        try {
            li = qr.query(sql, new BeanListHandler<Order>(Order.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  li;

    }
//发货
    public int send_goodsDo(String OR) {
        //调用连接池方法
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());
        String sql="update `order` set status=1 where orderNo = ? ";
        int row = 0;
        try {
           row= qr.update(sql,OR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(row);
        return  row;
    }
}
