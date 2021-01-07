import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class ceshi {
    @Test
    public  void ceshi1(){
        //创建连接池
        DriverManagerDataSource s=new DriverManagerDataSource();
        s.setDriverClassName("com.mysql.jdbc.Driver");
        s.setUrl("jdbc:mysql://127.0.0.1:3306/itdrs?serverTimezone=Asia/Shanghai");
        s.setUsername("root");
        s.setPassword("123456");

        //创建JDBC摸板
        JdbcTemplate jdt=new JdbcTemplate(s);
        //测试
        List<Map<String,Object>> list=jdt.queryForList("select * from neuedu_shipping");
        for (Map<String, Object> maps : list) {
            for (String s1 : maps.keySet()) {
                System.out.println(maps.get(s1));
            }
        }
    }
}
