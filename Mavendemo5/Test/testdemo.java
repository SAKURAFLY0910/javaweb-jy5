import main.com.itdr.people;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testdemo {
    @Test
    public void ceshi1(){
        ApplicationContext s=new ClassPathXmlApplicationContext("Spring.xml");
        people peo = (people)s.getBean("peo");
        peo.show();
        System.out.println( peo.toString());
        ((ClassPathXmlApplicationContext) s).close();
    }
}
