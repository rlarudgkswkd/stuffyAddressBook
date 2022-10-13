package com.springboot.webapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Controller
public class PostsController {

    @PostMapping("/posts/save")
    public String posts_Save(@RequestBody HashMap<String,Object> param){
        System.out.println("param : "+ param);
        return param.toString();
    }
}
