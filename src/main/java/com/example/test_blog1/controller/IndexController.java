package com.example.test_blog1.controller;

import com.example.test_blog1.dao.BlogDao;
import com.example.test_blog1.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    BlogDao blogDao;

    @RequestMapping("home")
    public String display(Model u)
    {
        List<Blog> toShow= blogDao.queryAllBlog() ;
        //test
       // Article defaultArticle=new Article("this is a default page");
        // u.addAttribute("first",defaultArticle);
        if(toShow.size()!=0)
        {
            Blog first=toShow.get(toShow.size()-1);
            u.addAttribute("blogs",toShow);
        }
        else
        {
            Blog default_blog =new Blog("this is a default page, generated by Controller","default title");
            toShow.add(default_blog);
            u.addAttribute("blogs", toShow);
        }







        return "index";
    }



}






