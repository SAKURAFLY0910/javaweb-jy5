package com.itdr.Controllers;


import com.itdr.Services.UserService;
import com.itdr.pojo.UserVO;
import com.itdr.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/manage/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(String uname, String psd, Model m){
        Users users = userService.login(uname, psd);
        if (users==null){
            return "forward:Indexlogin.jsp";
        }
        m.addAttribute("u",users);
        return "FirstPage";
    }


    @RequestMapping("/add.do")
    @ResponseBody
    public void add(Users users, HttpServletResponse response){
        int add = userService.add(users);
        try {
            response.getWriter().write(add+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    @RequestMapping(value = "/adds.do",method = RequestMethod.POST)
//    public void add(UserVO userVO){
//        System.out.println(userVO.getNum());
//    }


    // 根据id查询  使用正常 输出到页面
    @RequestMapping( "/check.do")
    public String check(Integer id, Model s){
        Users check = userService.check(id);
        System.out.println(check);
        if (check==null){
            return "forward:/WEB-INF/Indexlogin.jsp";
        }
        s.addAttribute("d",check);
        return "FirstPage";
    }


//   根据id查询 使用正常，输出json格式
//    @RequestMapping( "/check1.do")
//    @ResponseBody
//    public Users check1(Integer id){
//        Users check = userService.check(id);
//        System.out.println(check);
//        return check;
//    }


    //   根据id查询  使用正常，字符串格式

    @RequestMapping( "/check2.do")
    //@ResponseBody
    public void check2(Integer id,HttpServletResponse response){
        Users check = userService.check(id);
        try {
            response.getWriter().write(check.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//测试有误，参数进不去
//    @RequestMapping( "/check3.do/{id}")
//    @ResponseBody
//    public Users check3(@PathVariable("id") Integer id){
//        Users check = userService.check(id);
//        return check;
//    }
}
