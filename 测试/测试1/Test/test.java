import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test {

    @Test
    public void ceshi1(){
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar date = Calendar.getInstance();
        Date time = date.getTime();
        String format = s.format(time);
        System.out.println(format);
        String format1 = String.format("%tF", time);
        String format2 = String.format("%tT", time);
        System.out.println(format1+"  "+format2);
    }

    @Test
    public void ceshi2(){
        File file = new File("G:\\demo\\a.txt");
//        File s=new File("G:\\","a.txt");
        System.out.println(file);

    }
}
