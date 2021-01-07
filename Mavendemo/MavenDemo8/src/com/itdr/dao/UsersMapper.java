package com.itdr.dao;

import com.itdr.pojo.Users;


public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);


    //验证登录
    Users selectuserandpsd(String uname, String psd);


}