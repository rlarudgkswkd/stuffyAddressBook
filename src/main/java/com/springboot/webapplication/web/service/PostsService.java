package com.springboot.webapplication.web.service;

import com.springboot.webapplication.connection.jpa.Posts;
import com.springboot.webapplication.connection.jpa.PostsRepository;
import com.springboot.webapplication.web.dto.PostsListDto;
import com.springboot.webapplication.web.dto.PostsSaveDto;
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
    public Optional<Posts> findById(Long id) {
        return postsRepository.findById(id);
    }

    @Transactional
    public Long save(PostsSaveDto postsSaveDto){
        return postsRepository.save(postsSaveDto.toEntity()).getId();
    }

    @Transactional
    public Long update(PostsSaveDto postsSaveDto){
        return postsRepository.save(postsSaveDto.toUpdateEntity()).getId();
    }
}
