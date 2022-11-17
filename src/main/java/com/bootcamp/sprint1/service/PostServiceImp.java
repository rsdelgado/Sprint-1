package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.request.PostDTOReq;
import com.bootcamp.sprint1.repository.IPostRepository;
import com.bootcamp.sprint1.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Service
public class PostServiceImp implements IPostService{
    private final IPostRepository postRepository;



    public PostServiceImp(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void publishPost(PostDTOReq postDTOReq) {

    }


}
