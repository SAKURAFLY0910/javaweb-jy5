package main.com;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.Data;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class dao {
    public static void main(String[] args) throws SQLException {

        Connection co=null;
        try{
            ComboPooledDataSource v=new ComboPooledDataSource();
            QueryRunner s=new QueryRunner(v);
            co = v.getConnection();
            co.setAutoCommit(false);
            String aname="A";
            String bname="B";
            Integer price=50;
            int a=1/0;
            String sqls="update ices set price=price + ? where name= ?";
            String sqlss="update ices set price=price - ? where name= ?";
            int a1 = s.update(sqls,price,bname);
            int a2= s.update(sqlss,price,aname);
        }catch (Exception e){
            try{
                co.rollback();
                System.out.println("数据导入失败！");
            }catch (Exception q){
                q.printStackTrace();
            }
        }finally {
            if(co!=null){
                try{
                    co.commit();
                }catch (Exception r){
                    r.printStackTrace();
                }
            }
        }


//        String sqls="update ices set price=price + ? where name= ?";
//        String sqlss="update ices set price=price - ? where name= ?";
//        PreparedStatement bname1 = co.prepareStatement(sqls, 50, "bname");
//        PreparedStatement aname1 = co.prepareStatement(sqlss, 50, "aname");







//
//        String sql="update ices set price=price + ? where name= ?";
//        int update = sd.update(sql, prices, bname);
//
//
//
//        String sql="update ices set price=price - ? where name= ?";
//        int update = sd.update(sql, prices, aname);







    }
}
