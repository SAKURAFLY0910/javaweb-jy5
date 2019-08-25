package com.trys;

import java.io.File;
import java.io.IOException;

public class ceshi2 {
    public static void main(String[] args) throws IOException {
//        File file = new File("G:\\demo\\a.txt");
//        File s = new File("G:\\demo\\gt");
//        new File("G:\\demo\\gt\\a.txt").createNewFile();
//        boolean delete = s.delete();
//        boolean newFile = s.createNewFile();
//        File s=new File("G:\\","a.txt");
//        System.out.println(newFile);
//        boolean mkdir = s.mkdirs();
//        System.out.println(mkdir);
        File s=new File("g:\\njh");
//        boolean mkdirs = s.mkdir();
        boolean ede = s.renameTo( new File("g:\\ds"));
        System.out.println(ede);


    }


}
