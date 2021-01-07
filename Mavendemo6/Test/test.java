import main.spaing_mybatis.dao.Indexdao;
import main.Mvc.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SM.xml")
public class test {

    @Test
    public void test1(){
        ApplicationContext s=new ClassPathXmlApplicationContext("SM.xml");
        Indexdao bean = s.getBean(Indexdao.class);
        Product ge = bean.getone(10003);
        System.out.println(ge);
    }

    @Test
    public void test2(){
        ApplicationContext s=new ClassPathXmlApplicationContext("SM.xml");
        Indexdao bean = s.getBean(Indexdao.class);
//        Indexdao bean =(Indexdao)s.getBean("indexdao");
        Product ge = bean.getone(10003);
        System.out.println(ge);
    }

@Autowired
private  Indexdao indexdao;



    @Test
    public void test3(){
//        ApplicationContext s=new ClassPathXmlApplicationContext("SM.xml");
//        Indexdao bean = s.getBean(Indexdao.class);
//        Indexdao bean =(Indexdao)s.getBean("indexdao");
        Product ge = indexdao.getone(10003);
        System.out.println(ge);
    }



    int y;
    @Test
    public void ceshi4(){

        System.out.println(y);
    }


}
