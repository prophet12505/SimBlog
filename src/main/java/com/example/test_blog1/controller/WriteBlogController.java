package com.example.test_blog1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriteBlogController {
    @RequestMapping("/write")
    public String display()
    {
        return "write";
    }
}
