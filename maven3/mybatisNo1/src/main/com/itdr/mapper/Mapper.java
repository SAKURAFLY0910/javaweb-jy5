package main.com.itdr.mapper;

import main.com.itdr.pojo.Order;

import java.util.List;

public interface Mapper {
 //查询所有信息
 List<Order> getAll();
 //查询单个信息
 Order getone(Integer id);
 //查询满足两个条件的信息
 Order gettwo(Integer id,Integer status);
 //修改数据
 int updates(Integer id,Integer status);
 //增加数据
 int  adds(Integer status,String OrderNo,String createTime);
 //删除数据
 int detele(String OrderNo);
//删除数据
 void detele();
}
