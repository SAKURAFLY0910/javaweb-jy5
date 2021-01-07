package main.Mvc.Controllers;
import main.Mvc.Service.IndexService;
import main.Mvc.pojo.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
//
//  @RequestMapping("/ceshi.do")
//    public ModelAndView select(){
//    ModelAndView m=new ModelAndView();
//    m.addObject("p","世界");
//    m.setViewName("ms");
//    return  m;
//    }
//
//  @RequestMapping("/ceshi1.do")
//  public String select1(){
//    System.out.println("世界");
//    return  "ms";
//  }
//
//  @RequestMapping("/ceshi2.do")
//  public String select2(Integer s, HttpServletRequest request){
//  request.setAttribute("p",s);
//    return  "ms";
//  }
//  @Autowired
//  private IndexServiceIm indexServiceIm;

  @RequestMapping("/login.do")
  public ModelAndView select3(Integer id){
    ApplicationContext d=new ClassPathXmlApplicationContext("SM.xml");
    IndexService bean = (IndexService)d.getBean("indexServiceIm");
    Product gets = bean.getone(id);
    ModelAndView s=new ModelAndView();
    s.addObject("p",gets);
    s.setViewName("home");
    return  s;
  }

}
