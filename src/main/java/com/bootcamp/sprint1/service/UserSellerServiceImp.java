package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.FollowerCountDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerListDTORes;
import com.bootcamp.sprint1.entity.UserSeller;
import com.bootcamp.sprint1.repository.IUserSellerRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSellerServiceImp implements IUserSellerService{
    private final IUserSellerRepository sellerRepository;

    public UserSellerServiceImp(IUserSellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public FollowerCountDTORes followersCount(Integer userId) {
        UserSeller seller = sellerRepository.findById(userId);

        return new FollowerCountDTORes(seller.getUser_id(),seller.getUser_name(),seller.getFollowers().size());
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
