import com.sun.org.apache.xpath.internal.operations.Or;
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
import java.text.SimpleDateFormat;

public class ceshi1 {

    @Test
    public void ceshi2(){
//        查询单个数据
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Order re= mapper.getone(2);
//        Order re=sqlSession.selectOne("getone",2);
        System.out.println(re.getOrderNo());
    }

    @Test
    public void ceshi3(){
//        查询满足两个条件数据
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Order re= mapper.gettwo(3,0);
        System.out.println(re.getProductName());
        System.out.println(re.getOrderNo());
    }

    @Test
    public void ceshi4(){
//        修改满足两个条件数据
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        int updates = mapper.updates(1, 1);
        System.out.println(updates);
    }

    @Test
    public void ceshi5(){
//        增加数据
        long l = System.currentTimeMillis();
         SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fy = f.format(l);
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        sqlSession.commit();
//        Order s=new Order();
//        s.setStatus(0);
//        s.setOrderNo("a4a7b27f-0353-23564-ac08-98778dce28cc");
//        s.setCreateTime(fy);
//        int adds1 = sqlSession.insert("adds", s);
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        int adds = mapper.adds(0,"a4a7b27f-0353-23564-ac08-98778dce28cc",fy);
        System.out.println(adds);
    }

    @Test
    public void ceshi(){
//       删除数据
        SqlSession sqlSession = GetSqlSessionUtils.getOne();
        sqlSession.commit();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        int detele = mapper.detele("a4a7b27f-0353-23564-ac08-98778dce28cc");
        System.out.println(detele);
    }
}
