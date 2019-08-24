package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao ud = new UserDao();
//用户列表
    public ResponseCode selectAll(String pageSize, String pageNum){
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }

        List<Users> li = ud.selectAll(pageSize, pageNum);
        //如果集合为空？
        ResponseCode rs = ResponseCode.successRS(li);

        return rs;
    }

    //用户登录
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = null;
        if (username == null || username.equals("") || password == null || password.equals("")) {
//            rs.setStatus(1);
//            rs.setMag("账号或密码错误");
            rs = ResponseCode.defeatedRS(1, "参数为空");
            return rs;
        }
        //查找是否有这样一个用户
        Users u = ud.selectOne(username, password);
        //如果用户不存在
        if (u == null) {
//            rs.setStatus(1);
//            rs.setMag("账号或密码错误");
            rs = ResponseCode.defeatedRS(1, "账号或密码错误");
            return rs;
        }
        //用户权限
        if (u.getType() != 1) {

            rs = ResponseCode.defeatedRS(2, "没有操作权限");
            return rs;
        }

//           rs.setMag("用户登录成功！");
        rs = ResponseCode.successRS(u);
        return rs;
    }

    //用户禁用
    public ResponseCode selectOne(String uid) {
        ResponseCode rs = new ResponseCode();
        if (uid == null || uid.equals("")) {
            rs = ResponseCode.defeatedRS(Const.USER_PARAMETER_CODE, Const.USER_PARAMETER_MSG);
            return rs;
        }
       //字符串转数值
        Integer uid2 = 0;
        try {
            uid2 = Integer.parseInt(uid);
        } catch (Exception e) {
            rs.setStatus(105);
            rs.setMag("输入参数非法");
            return rs;
        }

        //查找是否有这样一个用户
        Users u = ud.selectOne(uid2);
//            Users u=null;
        //如果用户不存在

        if (u == null) {
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }


        //用户禁用情况
        if (u.getStats() == 1) {
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;
        }
      //禁用用户
        int row = ud.updateByUid(uid2);
        if (row <= 0) {
            rs.setStatus(106);
            rs.setMag("用户禁用更新失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(row);
        rs.setMag("用户禁用成功");
        return rs;
    }
    public Boolean yz(String uname) {
        //查找是否有这样一个用户
        Users u = ud.selectOne(uname);
        if (u == null) {
            return true;
        } else {
            return false;
        }
    }


//超级管理员
    public ResponseCode superDo(String pageSize, String pageNum) {
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }

        List<Users> li = ud.superDo(pageSize, pageNum);
        //如果集合为空？
        ResponseCode rs = ResponseCode.successRS(li);
        return rs;

    }
}