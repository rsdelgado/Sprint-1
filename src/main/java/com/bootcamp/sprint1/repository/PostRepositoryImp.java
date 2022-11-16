package com.bootcamp.sprint1.repository;

import com.bootcamp.sprint1.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImp implements ICrudRepository{
    List<Post> posts = new ArrayList<>();
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
}
