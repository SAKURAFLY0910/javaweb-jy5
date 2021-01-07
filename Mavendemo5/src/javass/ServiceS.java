package javass;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



@Service
public class ServiceS {


    private  TransactionTemplate ttel;


    private dao df;

    public TransactionTemplate getTtel() {
        return ttel;
    }

    public void setTtel(TransactionTemplate ttel) {
        this.ttel = ttel;
    }

    public dao getDf() {
        return df;
    }

    public void setDf(dao df) {
        this.df = df;
    }

    //    ApplicationContext sv1 = new ClassPathXmlApplicationContext("Springs.xml");
//    TransactionTemplate ttel = (TransactionTemplate) sv1.getBean("transactionTemplate",TransactionTemplate.class);
//    dao df=(dao)sv1.getBean("daos",dao.class);

//  @Resource
//   private dao df;
//    dao df=new dao();


//事务管理代码
//   private TransactionTemplate  ttel;

//    public TransactionTemplate getTtel() {
//        return ttel;
//    }
//
//    public void setTtel(TransactionTemplate ttel) {
//        this.ttel = ttel;
//    }
static  boolean bol=false;
    public boolean transferS(String aname, String bname, String price) {


        ttel.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                Integer prices = Integer.parseInt(price);
                int result1 = df.save(bname, prices);
                int a=1/0;
                int result2 = df.sub(aname, prices);
                if(result1==1&&result2==1){
                    bol=true;
                }else {
                    bol=false;
                }
            }

        });
        return  bol;
    }
//    //存钱
//    public int save(String bname, String price) {
//        Integer prices = Integer.parseInt(price);
//        int result = df.save(bname, prices);
//        return result;
//
//    }
//
//    //减钱
//    public int sub(String aname, String price) {
//        Integer prices = Integer.parseInt(price);
//        int result = df.sub(aname, prices);
//        return result;
//
//    }
}
