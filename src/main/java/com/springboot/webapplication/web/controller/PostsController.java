package com.springboot.webapplication.web.controller;

import com.springboot.webapplication.connection.jpa.PostsRepository;
import com.springboot.webapplication.web.dto.PostsSaveDto;
import com.springboot.webapplication.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/posts/save")
    public Long posts_Save(@RequestBody PostsSaveDto postsSaveDto){
        return postsService.save(postsSaveDto);
    }
}
