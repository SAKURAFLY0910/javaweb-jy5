package com.itdr.Utils;

import com.itdr.Service.UserService;

public class FANSHE {
   public static UserService getnew( String classname) throws Exception {
      String  value = PropertiesUtils.getValue("classname");
        Class cla=null;
        UserService u=null;
        try {
           cla = Class.forName(value);
            u = (UserService) cla.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
     return u;
    }


    public static void main(String[] args) {
        String value=null;
        try {
         value = PropertiesUtils.getValue("classname");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        UserService anew=getnew(value);
//        anew.getone();
    }
}
