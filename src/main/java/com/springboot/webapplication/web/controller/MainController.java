package com.springboot.webapplication.web.controller;

import com.springboot.webapplication.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * PATH에 지정된 view를 가져오는 Controller
 * mustache template 사용
 */
@RequiredArgsConstructor
@Controller
public class MainController {

    private final PostsService postsService;

    /**
     * Created by : 김경한
     * Date : 2022-10-09
     * Remark : 메인 화면 불러오기
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    /**
     * Created by : 김경한
     * Date : 2022-10-09
     * Remark : 저장 위해서 save template 가져오기
     * @return
     */
    @GetMapping("/templates/save")
    public String saveTemplate( ){
        return "saveTemplate";
    }

    /**
     * Created by : 김경한
     * Date : 2022-10-11
     * Remark : update 템플릿 가져오기
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/templates/update/{id}")
    public String updateTemplate(@PathVariable Long id, Model model){
        model.addAttribute("post", postsService.findById(id));
        return "updateTemplate";
    }
}
