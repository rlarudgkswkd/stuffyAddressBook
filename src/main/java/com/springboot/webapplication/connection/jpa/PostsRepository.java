package com.springboot.webapplication.connection.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query("SELECT m FROM Posts m ORDER BY m.id")
    List<Posts> findAllDesc();
}
