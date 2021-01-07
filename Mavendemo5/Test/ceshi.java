import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class ceshi {
    @Test
    public void ceshi2(){

        ApplicationContext v=new ClassPathXmlApplicationContext("SpringAoP.xml");
        JdbcTemplate sss = v.getBean("jdbcTemplate", JdbcTemplate.class);
        int update = sss.update("update neuedu_cart set user_id=24 where id=132");
        System.out.println(update);
//        List<Map<String, Object>> maps = ss.queryForList("select * from neuedu_cart");
//        for (Map<String, Object> map : maps) {
//            for (String s1 : map.keySet()) {
//                System.out.println(map.get(s1));
//            }
//        }

    }
}
