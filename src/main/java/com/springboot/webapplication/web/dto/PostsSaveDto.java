package com.springboot.webapplication.web.dto;

import com.springboot.webapplication.connection.jpa.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsSaveDto {
    private Long id;
    private String name;
    private Long age;
    private String phone_number;
    private LocalDateTime modifiedDate;

    public PostsSaveDto(Posts entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.phone_number = entity.getPhone_number();
        this.modifiedDate = entity.getModifiedDate();
    }

    public Posts toEntity(){
        return Posts.builder()
                .id(id)
                .name(name)
                .age(age)
                .phone_number(phone_number)
                .build();
    }

}
