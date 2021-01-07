package com.itdr.Controllers;


import com.itdr.Services.UserService;
import com.itdr.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/user")
public class UserController {


    private UserService userService;

    @RequestMapping("/login.do")
    public String login(String uname, String psd, Model m){
        Users users = userService.login(uname, psd);
        if (users==null){
            return "redirect:Indexlogin.jsp";
        }
        m.addAttribute("u",users);
        return "FirstPage";
    }


}
