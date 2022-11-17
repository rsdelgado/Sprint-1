package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.request.PostDTOReq;
import com.bootcamp.sprint1.dto.respose.FollowerCountDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerListDTORes;

public interface IUserSellerService {

    FollowerCountDTORes followersCount(Integer userId);

    FollowerListDTORes getFollowers(Integer userId,String order);

    void publishPost(PostDTOReq postDTOReq);

}
