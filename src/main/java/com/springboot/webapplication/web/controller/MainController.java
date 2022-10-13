package com.springboot.webapplication.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model){
        return "index";
    }

    @GetMapping("/posts/templates/save")
    public String posts_Save( ){
        return "posts_save";
    }
}