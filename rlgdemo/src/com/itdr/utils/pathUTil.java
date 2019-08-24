package com.itdr.utils;

public class pathUTil {

    public static String getpath(String path){


        String s1=path.replace(".","/");

        String sar[]=s1.split("/");

        return sar[1];
    }
}
