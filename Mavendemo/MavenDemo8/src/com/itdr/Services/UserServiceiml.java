package com.itdr.Services;

import com.itdr.dao.UsersMapper;
import com.itdr.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceiml implements  UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(String uname, String psd) {
        Users users = usersMapper.selectuserandpsd(uname, psd);

        return users;
    }

    @Override
    public int add(Users users) {
        int insert = usersMapper.insert(users);
        return  insert;
    }

    @Override
    public Users check(Integer id) {
        Users users = usersMapper.selectByPrimaryKey(id);
        return users;
    }
}
