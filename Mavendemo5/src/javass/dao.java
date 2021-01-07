package javass;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Data
public class dao {
    //创建容器，获取对象
//
//    ApplicationContext sv = new ClassPathXmlApplicationContext("Springs.xml");
//    JdbcTemplate sd = (JdbcTemplate) sv.getBean("jdt");


    private JdbcTemplate sd;

    public void setSd(JdbcTemplate sd) {
        this.sd = sd;
    }

    //加
     public int save(String bname,Integer prices){
      String sql="update ices set price=price + ? where name= ?";
        int update = sd.update(sql, prices, bname);
        return update;
    }
    //减
    public int sub(String aname,Integer prices){
        String sql="update ices set price=price - ? where name= ?";
        int update = sd.update(sql, prices, aname);
        return update;
    }
}
