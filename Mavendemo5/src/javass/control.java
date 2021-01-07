package javass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfer")
public class control extends HttpServlet {

   ApplicationContext sv = new ClassPathXmlApplicationContext("Springs.xml");
    ServiceS se = (ServiceS) sv.getBean("serviceS");


//    service se=new service();

//    @Resource
////    service se;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String aname = request.getParameter("aname");
        String bname = request.getParameter("bname");
        String price = request.getParameter("price");

        System.out.println(aname);
        System.out.println(bname);
        System.out.println(price);
//b存/加
       boolean bol= se.transferS(aname,bname,price);
//        int tr = se.save(bname, price);
//        int su = se.sub(aname, price);


        if (bol) {
            System.out.println("转账成功！");
            response.getWriter().write("转账成功！");
        } else {
            System.out.println("转账失败！");
            response.getWriter().write("转账失败！");
        }
    }
}
