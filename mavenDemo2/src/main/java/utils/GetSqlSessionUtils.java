package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSessionUtils {
  private static  SqlSessionFactory Factory;
  static {
      String resource = "sqlMapConfig.xml";
      InputStream in = null;
      try {
          in = Resources.getResourceAsStream(resource);
      } catch (IOException e) {
          e.printStackTrace();
      }
       Factory = new SqlSessionFactoryBuilder().build(in);

  }

    public static  SqlSession getOne(){
        SqlSession sqlSession = Factory.openSession(true);
        return  sqlSession;
    }

}
