package com.itdr.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static String getValue(String key) throws Exception {
        Properties p=new Properties();
//        InputStream in=new FileInputStream("F:\\IdeaDocument\\测试\\测试1\\resources\\da.properties");
//        InputStream in = PropertiesUtils.class.getResourceAsStream("da.properties");
        InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("da.properties");
        p.load(in);
        String s=p.getProperty(key);
    return  s;
    }
}
