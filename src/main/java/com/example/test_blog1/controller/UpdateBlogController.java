package com.example.test_blog1.controller;

import com.example.test_blog1.dao.BlogDao;
import com.example.test_blog1.entity.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@Controller
public class UpdateBlogController {
    @Autowired
    BlogDao blogDao;

    @RequestMapping(value = "home",method = RequestMethod.POST)
    public String display(@RequestParam HashMap<String,String> formdata, HttpSession httpSession)
    {
        String blog_content =formdata.get("mytextarea");
        String blog_title =formdata.get("title");

        //logger configuration
        Logger logger = LoggerFactory.getLogger("SampleLogger");
        logger.info(blog_content);
        logger.info("blog_content");
        System.out.println(blog_content);

        blogDao.saveBlog(new Blog(blog_content,blog_title));

        if(httpSession.getAttribute("user_id")==null)
            return "login";
        return "redirect:home";

    }




}

