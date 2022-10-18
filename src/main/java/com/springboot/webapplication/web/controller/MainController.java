package com.springboot.webapplication.web.controller;

import com.springboot.webapplication.connection.jpa.Posts;
import com.springboot.webapplication.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/templates/save")
    public String saveTemplate( ){
        return "saveTemplate";
    }

    @GetMapping("/posts/update/{id}")
    public String updateTemplate(@PathVariable Long id, Model model){
        model.addAttribute("posts", postsService.findById(id));
        return "updateTemplate";
    }
}
