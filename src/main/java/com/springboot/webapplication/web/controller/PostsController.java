package com.springboot.webapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostsController {

    @PostMapping("/posts/save")
    public String posts_Save( ){
        return "posts_save";
    }
}
