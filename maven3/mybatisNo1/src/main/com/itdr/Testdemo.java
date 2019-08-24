package main.com.itdr;

import com.sun.org.apache.xpath.internal.operations.Or;
import main.Utils.GetSqlSessionUtils;
import main.com.itdr.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Testdemo {
    public static void main(String[] args) {
        String resource = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory Factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = Factory.openSession(true);

        List<Order> getAll = sqlSession.selectList("getAll");
        for (Order order : getAll) {
            System.out.println(order.getOrderNo());
        }
    }
}