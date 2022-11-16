package com.bootcamp.sprint1.service;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{
    private final IPostService postService;

    public PostServiceImp(IPostService postService) {
        this.postService = postService;
    }
}
