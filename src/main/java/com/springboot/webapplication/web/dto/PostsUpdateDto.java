package com.springboot.webapplication.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateDto {
    private String name;
    private Long age;
    private String phone_number;

//    @Builder
    public PostsUpdateDto(String name, Long age, String phone_number) {
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
    }
}
