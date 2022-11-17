package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.FollowedListDTORes;
import com.bootcamp.sprint1.dto.respose.PostFollowedByDateDTORes;
import com.bootcamp.sprint1.repository.IUserBuyerRepository;
import org.springframework.stereotype.Service;


@Service
public class UserBuyerServiceImp implements IUserBuyerService{
    private final IUserBuyerRepository userBuyerRepository;

    public UserBuyerServiceImp(IUserBuyerRepository userBuyerRepository) {
        this.userBuyerRepository = userBuyerRepository;
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {

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
