import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}
