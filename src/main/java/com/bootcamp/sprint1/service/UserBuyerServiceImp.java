package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.repository.IUserBuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBuyerServiceImp implements IUserBuyerService{
    private final IUserBuyerRepository userBuyerRepository;

    public UserBuyerServiceImp(IUserBuyerRepository userBuyerRepository) {
        this.userBuyerRepository = userBuyerRepository;
    }

}
