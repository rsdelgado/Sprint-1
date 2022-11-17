package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.request.PostDTOReq;
import com.bootcamp.sprint1.dto.respose.FollowerCountDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerListDTORes;
import com.bootcamp.sprint1.dto.respose.UserDTORes;
import com.bootcamp.sprint1.entity.Post;
import com.bootcamp.sprint1.entity.UserBuyer;
import com.bootcamp.sprint1.entity.UserSeller;
import com.bootcamp.sprint1.repository.IPostRepository;
import com.bootcamp.sprint1.repository.IUserSellerRepository;
import com.bootcamp.sprint1.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSellerServiceImp implements IUserSellerService{
    private final IUserSellerRepository sellerRepository;
    private final IPostRepository postRepository;

    public UserSellerServiceImp(IUserSellerRepository sellerRepository, IPostRepository postRepository) {
        this.sellerRepository = sellerRepository;
        this.postRepository = postRepository;
    }

    @Override
    public FollowerCountDTORes followersCount(Integer userId) {
        UserSeller seller = sellerRepository.findById(userId);

        return new FollowerCountDTORes(seller.getUser_id(),seller.getUser_name(),seller.getFollowers().size());
    }

    @Override
    public FollowerListDTORes getFollowers(Integer userId, String order) {
        UserSeller seller = sellerRepository.findById(userId);
        List<UserBuyer> buyers = seller.getFollowers();
        List<UserDTORes> userDTOResList = buyers.stream().map(e->new UserDTORes(e)).collect(Collectors.toList());
        if (order.equals("name_asc"))
            userDTOResList.stream().sorted(Comparator.comparing(UserDTORes::getUser_name));
        if (order.equals("name_desc"))
            userDTOResList.stream().sorted(Comparator.comparing(UserDTORes::getUser_name).reversed());

        return new FollowerListDTORes(seller.getUser_id(),seller.getUser_name(),userDTOResList);
    }
    @Override
    public void publishPost(PostDTOReq postDTOReq) {
        Post p= Mapper.createObjectMapper().convertValue(postDTOReq, Post.class);
        postRepository.createPost(p);
        sellerRepository.findById(postDTOReq.getUser_id()).getPosts().add(p);
    }

}
