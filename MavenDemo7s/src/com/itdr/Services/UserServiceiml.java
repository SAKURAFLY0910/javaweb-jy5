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
}
