package com.itdr.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class demo1 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        long l2 = Calendar.getInstance().getTimeInMillis();
        long l3 = new Date().getTime();

        System.out.println(l);
        System.out.println(l2);
        System.out.println(l3);

        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
        String s1=s.format(l);
        String s2=s.format(l2);
        String s3=s.format(l3);

        Timestamp v=new Timestamp(l2);
        System.out.println("+++++++++++++");
        System.out.println(v);
        System.out.println("+++++++++++++");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
 }
}
