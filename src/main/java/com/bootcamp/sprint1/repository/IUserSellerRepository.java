package com.bootcamp.sprint1.repository;


import com.bootcamp.sprint1.entity.UserSeller;

public interface IUserSellerRepository{
    UserSeller findById(Integer id);

}
