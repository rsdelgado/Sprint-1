package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.FollowerCountDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerListDTORes;

public interface IUserSellerService {
    FollowerCountDTORes followers(Integer userId);
    FollowerListDTORes getFollowers(Integer userId);
    FollowerListDTORes getFollowersSortedByName(String order);


}
