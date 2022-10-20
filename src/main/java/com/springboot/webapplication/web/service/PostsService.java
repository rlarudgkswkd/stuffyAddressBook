package com.springboot.webapplication.web.service;

import com.springboot.webapplication.connection.jpa.Posts;
import com.springboot.webapplication.connection.jpa.PostsRepository;
import com.springboot.webapplication.web.dto.PostsListDto;
import com.springboot.webapplication.web.dto.PostsSaveDto;
import com.springboot.webapplication.web.dto.PostsUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<PostsListDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostsListDto findById(Long id) {
        Posts post = postsRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("해당 연락처가 없음 id="+id));
        return new PostsListDto(post);
    }

    @Transactional
    public Long save(PostsSaveDto postsSaveDto){
        return postsRepository.save(postsSaveDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id ,PostsUpdateDto postsUpdateDto){
        Posts post = postsRepository.findById(id).orElseThrow(()
        -> new IllegalArgumentException("해당 연락처가 없음 id="+id));

        post.update(postsUpdateDto.getName(),postsUpdateDto.getAge(), postsUpdateDto.getPhone_number());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(()
        -> new IllegalArgumentException("해당 연락처가 없음 ID="+id));

        postsRepository.delete(post);
    }
}
