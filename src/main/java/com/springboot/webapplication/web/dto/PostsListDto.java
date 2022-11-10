package com.springboot.webapplication.web.dto;

import com.springboot.webapplication.connection.jpa.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListDto {
    private Long id;
    private String name;
    private Long age;
    private String phone_number;
    private LocalDateTime modifiedDate;

    public PostsListDto(Posts entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.phone_number = entity.getPhone_number();
        this.modifiedDate = entity.getModifiedDate();
    }
}
