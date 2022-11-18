package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.FollowedListDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerListDTORes;
import com.bootcamp.sprint1.dto.respose.PostFollowedByDateDTORes;

import java.util.List;

public interface IUserBuyerService {
    void follow(Integer userId, Integer userIdToFollow);
    FollowedListDTORes getFollowed(Integer userId, String order);

    PostFollowedByDateDTORes getLastPosts(Integer userId, String order);

    void unfollow(Integer userId, Integer userIdToUnfollow);

}
