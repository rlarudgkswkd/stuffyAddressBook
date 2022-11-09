package com.springboot.webapplication.connection.jpa;

import com.springboot.webapplication.connection.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * JPA Entity 지정
 */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column
    private Long age;

    @Column(length = 200)
    private String phone_number;

    @Builder
    public Posts(Long id, String name, Long age, String phone_number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
    }

    public void update(String name, Long age, String phone_number){
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
    }
}
