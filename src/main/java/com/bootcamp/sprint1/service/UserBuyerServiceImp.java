package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.FollowedListDTORes;
import com.bootcamp.sprint1.dto.respose.PostFollowedByDateDTORes;
import com.bootcamp.sprint1.entity.UserBuyer;
import com.bootcamp.sprint1.entity.UserSeller;
import com.bootcamp.sprint1.repository.IUserBuyerRepository;
import com.bootcamp.sprint1.repository.IUserSellerRepository;
import org.springframework.stereotype.Service;


@Service
public class UserBuyerServiceImp implements IUserBuyerService{
    private final IUserBuyerRepository userBuyerRepository;
    private final IUserSellerRepository userSellerRepository;

    public UserBuyerServiceImp(IUserBuyerRepository userBuyerRepository, IUserSellerRepository userSellerRepository) {
        this.userBuyerRepository = userBuyerRepository;
        this.userSellerRepository = userSellerRepository;
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
        UserBuyer buyer = userBuyerRepository.findById(userId);
        UserSeller seller = userSellerRepository.findById(userIdToFollow);
        buyer.getFollowed().add(seller);
        seller.getFollowers().add(buyer);
    }

    @Override
    public FollowedListDTORes getFollowed(Integer userId) {

        return null;
    }

    @Override
    public PostFollowedByDateDTORes getLastPosts(Integer userId) {

        return null;
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {

    }

    @Override
    public PostFollowedByDateDTORes getLastPostsSortedDate(String order) {
        return null;
    }

    @Override
    public FollowedListDTORes getFollowedSortedByName(String order) {
        return null;
    }
}
