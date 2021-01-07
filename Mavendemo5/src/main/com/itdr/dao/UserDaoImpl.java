package main.com.itdr.dao;

public class UserDaoImpl implements  Userdao {
    @Override
    public void save() {
        System.out.println("保存用户！");
    }
}
