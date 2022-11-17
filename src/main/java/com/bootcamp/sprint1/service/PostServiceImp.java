package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.request.PostDTOReq;
import com.bootcamp.sprint1.entity.Post;
import com.bootcamp.sprint1.repository.IPostRepository;
import com.bootcamp.sprint1.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{
    private final IPostRepository postRepository;



    public PostServiceImp(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }




}
