package com.itdr.Demo2.mapper;

import com.itdr.pojo.Order;

import java.util.List;

public interface OrderMapper {
 //    查
    List<Order> getAll();
 //    改
    int updates(Integer status,Integer id);
 //    增
    int adds (Integer status,String orderNo,Integer payment);
  //   删
    int det(Integer id);
    //查询 两个参数
    Order check(Integer id,String productName);
    //多个id
    List<Order> checks (List<Integer>  lis);


}
