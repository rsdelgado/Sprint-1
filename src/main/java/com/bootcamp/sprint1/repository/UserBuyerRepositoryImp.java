package com.bootcamp.sprint1.repository;

import com.bootcamp.sprint1.entity.Post;
import com.bootcamp.sprint1.entity.UserBuyer;
import com.bootcamp.sprint1.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserBuyerRepositoryImp implements IUserBuyerRepository{
    List<UserBuyer> buyers = new ArrayList();

    public UserBuyerRepositoryImp() {
        loadBuyers();
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

    private void loadBuyers(){
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:buyers.json");
            buyers = Mapper.createObjectMapper().readValue(jsonFile, new TypeReference<List<UserBuyer>>() {});
        }catch (Exception ex){
            System.out.println("Buyers not found " + ex.getMessage());
        }
    }
}
