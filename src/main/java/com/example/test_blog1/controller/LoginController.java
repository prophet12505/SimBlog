package com.example.test_blog1.controller;

import com.example.test_blog1.dao.BlogDao;
import com.example.test_blog1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import static java.lang.System.out;

@Controller
public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String login(HttpSession httpSession)
    {
        if(httpSession.getAttribute("user_id")!=null)
            return "redirect:home";

        return "login";

    }
    @RequestMapping(value = "submit_login",method = RequestMethod.POST)
    public String submitLogin(@RequestParam HashMap<String,String> formData, HttpSession httpSession, Model u)
    {
        String username=formData.get("username_input");
        String password=formData.get("password_input");
        //System.out.println("username:"+username);//test
        //System.out.println("password:"+password);//test
        int user_id=userDao.getUserIdByLogin(username,password);
        //int user_id=-1;
        System.out.println(user_id);
        if(user_id==-1)
        {

            return "redirect:/";
            //return "redirect:home"; //test,to bypass login
        }

        else
        {
            httpSession.setAttribute("user_id",user_id);
            httpSession.setMaxInactiveInterval(60);//keep login time
            u.addAttribute("message","Error");

            return "redirect:home";
        }
    }






}
