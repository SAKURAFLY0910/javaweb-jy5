package com.itdr.testdemo;

import com.itdr.pojo.Users;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.QueryConnectionTester;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test1 {

   @Test
    public void test2(){
       SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
       long l2=1565945434477L;
//       long ll=1566100489856
Date d=new Date();
long l4=d.getTime();
       System.out.println(d.getTime());
       long l = System.currentTimeMillis();
//       String format = s.format(l);
       System.out.println(l);
   }

    @Test
    public void test3() {
        ComboPooledDataSource  con=new ComboPooledDataSource();
        try {
            Connection s=con.getConnection();
            String sql="select type from Users where uname='克苏鲁'";
            PreparedStatement pr = s.prepareStatement(sql);
            ResultSet we = pr.executeQuery();
            while (we.next()){
            String type=we.getString("type");
                System.out.println(type);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        ComboPooledDataSource  con=new ComboPooledDataSource();
//        String s="世界";
        String s1="123";
//        Integer v=Integer.parseInt(s);
        Integer v1=Integer.parseInt(s1);
//        System.out.println(v);
        System.out.println(v1);
    }


    @Test
    public void test5() {
        long wr=new Date().getTime();
        String de= String.valueOf(wr);
        System.out.println(wr);
        System.out.println(de);
    }







    @Test
    public void test6() {
        String s = UUID.randomUUID().toString();
        long time = new Date().getTime();
        SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
        String de = ss.format(time);

//        int i = UUID.randomUUID().toString().hashCode();
//        String format = String.format("%015d", i);

        System.out.println(de);
        System.out.println(s);
    }


//    @Test
//    public void test8() {
//        ComboPooledDataSource re=new ComboPooledDataSource();
//        try {
//            Connection coo = re.getConnection();
//            String sql = "select *from Users ";
//            PreparedStatement pt = null;
//            try {
//                pt = coo.prepareStatement(sql);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            ResultSet res = pt.executeQuery();
//            while (res.next()) {
//                res.getString(6);
//            }

@Test
public void test9() {
    String s="123a";
    String ss="15";
    int a=Integer.parseInt(s);
    int b=Integer.parseInt(ss);
    System.out.println(a);
    System.out.println(b);
}

@Test
    public void test12(){
    Object obj=new Object();
    List aList=new ArrayList();
    List bList=new LinkedList();

    long t1=System.currentTimeMillis();
    for(int i=0;i<50000;i++){
        aList.add(0,obj);
    }
    long t2=System.currentTimeMillis()-t1;

    t1=System.currentTimeMillis();
    for(int i=0;i<50000;i++){
        bList.add(0,obj);
    }
    long t3=System.currentTimeMillis()-t1;

}





 }