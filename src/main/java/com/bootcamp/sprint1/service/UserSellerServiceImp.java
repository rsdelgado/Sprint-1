package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.FollowerCountDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerListDTORes;
import com.bootcamp.sprint1.repository.IUserSellerRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSellerServiceImp implements IUserSellerService{
    private final IUserSellerRepository sellerRepository;

    public UserSellerServiceImp(IUserSellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public FollowerCountDTORes followers(Integer userId) {
        return null;
    }

    @Override
    public FollowerListDTORes getFollowers(Integer userId) {
        return null;
    }

    @Override
    public FollowerListDTORes getFollowersSortedByName(String order) {
        return null;
    }
}
