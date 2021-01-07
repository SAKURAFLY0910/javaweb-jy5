package com.itdr.pojo;

import lombok.Data;

import java.util.List;


@Data
public class UserVO {
    private Integer num;
    private List<Users> li;
    private  Users users;
}
