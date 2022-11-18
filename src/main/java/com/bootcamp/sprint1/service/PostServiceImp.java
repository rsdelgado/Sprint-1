package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.repository.IPostRepository;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{
    private final IPostRepository postRepository;
    public PostServiceImp(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }




}
