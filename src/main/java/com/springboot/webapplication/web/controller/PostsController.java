package com.springboot.webapplication.web.controller;

import com.springboot.webapplication.web.dto.PostsSaveDto;
import com.springboot.webapplication.web.dto.PostsUpdateDto;
import com.springboot.webapplication.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 핵심 로직 call 하는 controller
 * OAuth 적용으로 "/posts" 경로는 유저 권한이 'USER' 경우에만 접속 가능
 */
@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/posts/save")
    public Long posts_Save(@RequestBody PostsSaveDto postsSaveDto){
        return postsService.save(postsSaveDto);
    }

    @PutMapping("/posts/update/{id}")
    public Long posts_Update(@PathVariable Long id, @RequestBody PostsUpdateDto postsUpdateDto){
        return postsService.update(id, postsUpdateDto);
    }

    @DeleteMapping("/posts/delete/{id}")
    public Long posts_Delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
