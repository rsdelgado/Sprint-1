package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.FollowerCountDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerListDTORes;
import com.bootcamp.sprint1.dto.respose.UserDTORes;
import com.bootcamp.sprint1.entity.UserBuyer;
import com.bootcamp.sprint1.entity.UserSeller;
import com.bootcamp.sprint1.repository.IUserSellerRepository;
import com.bootcamp.sprint1.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        UserSeller seller = sellerRepository.findById(userId);
        List<UserBuyer> buyers = seller.getFollowers();
        List<UserDTORes> userDTOResList = buyers.stream().map(e->new UserDTORes(e)).collect(Collectors.toList());
        return new FollowerListDTORes(seller.getUser_id(),seller.getUser_name(),userDTOResList);
    }

    @Override
    public FollowerListDTORes getFollowersSortedByName(String order) {
        return null;
    }
}
