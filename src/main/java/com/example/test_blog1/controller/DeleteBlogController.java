package com.example.test_blog1.controller;

import com.example.test_blog1.dao.BlogDao;
import com.example.test_blog1.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class DeleteBlogController {
    @Autowired
     BlogDao blogDao;

    @RequestMapping("delete_blog/")
    public String deleteBlog(Model u, @RequestParam HashMap<String,String> formData, HttpSession httpSession)
    {
        String blog_id=formData.get("blog_id");
        blogDao.deleteBlogById(Integer.parseInt(blog_id.substring(1,blog_id.length()-1)));

        /*if(httpSession.getAttribute("user_id")==null)//login timeout
            return "redirect:/";*/
        return "redirect:../home";
    }
}
