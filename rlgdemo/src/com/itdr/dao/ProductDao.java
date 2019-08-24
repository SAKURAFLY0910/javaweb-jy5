package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductDao {

//产品列表
    public List<Product> selectAll(String pageNum, String pageSize) {
        //调用连接池方法
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from product";
        List<Product> li = null;


        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(li);
        return li;
    }




//查找一个产品
    public Product selectOne(Integer ids) {
//        ComboPooledDataSource co=PoolUtil.getCom();
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());
        String sql="select *from product where id=? ";

        Product u=null;

        try{
            u=qr.query(sql,new BeanHandler<Product>(Product.class),ids);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  u;
    }




//产品搜索
    public Product searchDo(Integer src1) {
        //调用连接池方法
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from product where id=?";
        Product li=null;

        try {
            li = qr.query(sql, new BeanHandler<Product>(Product.class),src1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;

    }

    public Product searchDo(String src) {
        //调用连接池方法
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from product where pname=? ";
        Product li=null;
        try {
            li = qr.query(sql, new BeanHandler<Product>(Product.class),src);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
//产品详情
public Product detailDo(Integer det1) {
    //调用连接池方法
    QueryRunner qr = new QueryRunner(PoolUtil.getCom());
    String sql = "select * from product where id=?";
    Product li=null;

    try {
        li = qr.query(sql, new BeanHandler<Product>(Product.class),det1);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return li;

}
    public Product detailDo(String det) {
        //调用连接池方法
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from product where pname=? ";
        Product li=null;
        try {
            li = qr.query(sql, new BeanHandler<Product>(Product.class),det);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

//产品上下架
    public int set_sale_statusDo(Integer ids,Integer tus) {
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());
        String sql="update product set status=? where id=? ";
        int row=0;

        try{
            row=qr.update(sql,tus,ids);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return row;
    }


//增加产品

    public int saveDo(String pname, Integer cId, String subtitle, String imageHost, Integer pri, Integer tus){
        long wr=new Date().getTime();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
        String de = s.format(wr);



        QueryRunner qr=new QueryRunner(PoolUtil.getCom());
        String sql="insert into product(pname,categoryId,subtitle,imageHost,price,status,createTime,updateTime) " +
                "values (?,?,?,?,?,?,?,?)";

        int row=0;
        try {
            row=qr.update(sql,pname,cId,subtitle,imageHost,pri,tus,de,de);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  row;
    }
}
