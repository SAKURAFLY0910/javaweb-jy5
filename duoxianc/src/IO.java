import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class IO {
    public static void main(String[] args) throws Exception {
        Properties s=new Properties();
        FileReader v=new FileReader("G:\\ceshi.properties");
        s.load(v);
        String a = s.getProperty("a");
        System.out.println(a);


    }
}
