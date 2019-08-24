package com.itdr.Controller;

import com.itdr.Service.UserService;
import com.itdr.Service.Userservice1;
import com.itdr.Utils.FANSHE;

public class UserController {
    static  UserService us;

    static {
        try {
            us = FANSHE.getnew("classname");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    us.getone();
    }
}
