package com.springboot.webapplication.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostsListDto {
    private Long id;
    private String name;
    private Long age;
    private LocalDate modifiedDate;

    public PostsListDto(Long id) {
        this.id = id;
    }
}
