package com.bootcamp.sprint1.repository;

import com.bootcamp.sprint1.entity.UserBuyer;
import com.bootcamp.sprint1.entity.UserSeller;
import com.bootcamp.sprint1.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserSellerRepositoryImp implements IUserSellerRepository{
    List<UserSeller> sellers = new ArrayList<>();

    public UserSellerRepositoryImp() {
        loadSellers();
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

    private void loadSellers(){
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:sellers.json");
            sellers = Mapper.createObjectMapper().readValue(jsonFile, new TypeReference<List<UserSeller>>() {});
        }catch (Exception ex){
            System.out.println("Sellers not found " + ex.getMessage());
        }
    }
}
