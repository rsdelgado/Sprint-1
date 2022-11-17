package com.bootcamp.sprint1.repository;

import com.bootcamp.sprint1.entity.UserBuyer;

public interface IUserBuyerRepository{
    UserBuyer findById(Integer id);

}
