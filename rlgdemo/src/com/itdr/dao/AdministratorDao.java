package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdministratorDao {
    public List<Users> superDo(String pageSize, String pageNum){


        QueryRunner qr=new QueryRunner(PoolUtil.getCom());

        String sql="select *from Users where type=1";
        List<Users> li=null;
        try {
            li=qr.query(sql,new BeanListHandler<Users>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  li;


    }

}
