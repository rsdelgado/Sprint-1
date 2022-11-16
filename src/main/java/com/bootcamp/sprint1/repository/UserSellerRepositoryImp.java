package com.bootcamp.sprint1.repository;

import com.bootcamp.sprint1.entity.UserSeller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserSellerRepositoryImp implements ICrudRepository{
    List<UserSeller> sellers = new ArrayList<>();

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
