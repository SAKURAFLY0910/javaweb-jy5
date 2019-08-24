package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.AdministratorDao;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdministratorService {


    public ResponseCode superDo(String pageSize, String pageNum, String username) {
        AdministratorDao ud = new AdministratorDao();


        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }

        ComboPooledDataSource re = new ComboPooledDataSource();
        ResponseCode rs = new ResponseCode();
        Connection coo = null;
        String type = null;
        int types = 0;
        try {
            coo = re.getConnection();

            String sql = "select type from Users where uname='?'";
            PreparedStatement pt = coo.prepareStatement(sql);
            ResultSet res = pt.executeQuery();

            while (res.next()) {
                type = res.getString("type");
                types = Integer.parseInt(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (types < 2) {
            rs.setMag("用户权限不够！");
        }
        List<Users> li = ud.superDo(pageSize, pageNum);
     rs = ResponseCode.successRS(li);
        return rs;
    }
}



