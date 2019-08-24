import main.Utils.GetSqlSessionUtils;
import main.com.itdr.mapper.Mapper;
import main.com.itdr.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ceshi1 {

    @Test
    public void ceshi2(){
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Order re= mapper.getone(2);
//        Order re=sqlSession.selectOne("getone",2);
        System.out.println(re.getOrderNo());
    }
}
