package com.bootcamp.sprint1.repository;

import com.bootcamp.sprint1.entity.Post;
import com.bootcamp.sprint1.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImp implements IPostRepository{
    List<Post> posts = new ArrayList<>();

    public PostRepositoryImp() {
        loadPosts();
    }

    @Override
    public Object create(Object o) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object delete(Object o) {
        return null;
    }

    @Override
    public Object findById(Object o) {
        return null;
    }

    private void loadPosts(){
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:posts.json");
            posts = Mapper.createObjectMapper().readValue(jsonFile, new TypeReference<List<Post>>() {});
        }catch (Exception ex){
            System.out.println("Posts not found " + ex.getMessage());
        }
    }
}
