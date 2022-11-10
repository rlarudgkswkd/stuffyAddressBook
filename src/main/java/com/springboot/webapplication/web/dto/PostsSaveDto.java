package com.springboot.webapplication.web.dto;

import com.springboot.webapplication.connection.jpa.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveDto {
    private String name;
    private Long age;
    private String phone_number;

    @Builder
    public PostsSaveDto(String name, Long age, String phone_number){
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
    }

    public Posts toEntity(){
        return Posts.builder()
                .name(name)
                .age(age)
                .phone_number(phone_number)
                .build();
    }

    public Posts toUpdateEntity(){
        return Posts.builder()
                .name(name)
                .age(age)
                .phone_number(phone_number)
                .build();
    }
}
