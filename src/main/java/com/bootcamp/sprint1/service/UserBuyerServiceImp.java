package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.*;
import com.bootcamp.sprint1.entity.Post;
import com.bootcamp.sprint1.entity.UserBuyer;
import com.bootcamp.sprint1.entity.UserSeller;
import com.bootcamp.sprint1.repository.IUserBuyerRepository;
import com.bootcamp.sprint1.repository.IUserSellerRepository;
import com.bootcamp.sprint1.util.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
    public FollowedListDTORes getFollowed(Integer userId, String order) {
        UserBuyer buyer = userBuyerRepository.findById(userId);
        List<UserSeller> sellers = buyer.getFollowed();
        List<UserDTORes> userDTOResList = sellers.stream().map(e->new UserDTORes(e)).collect(Collectors.toList());
        if (order.equals("name_asc"))
            userDTOResList.stream().sorted(Comparator.comparing(UserDTORes::getUser_name));
        if (order.equals("name_desc"))
            userDTOResList.stream().sorted(Comparator.comparing(UserDTORes::getUser_name).reversed());

        return new FollowedListDTORes(buyer.getUser_id(),buyer.getUser_name(),userDTOResList);
    }

    @Override
    public PostFollowedByDateDTORes getLastPosts(Integer userId, String order) {
        UserBuyer buyer= userBuyerRepository.findById(userId);
        List<UserSeller> followed = buyer.getFollowed();
        List<PostDTORes> postsFollowed =  new ArrayList<>();
        for (UserSeller seller: followed) {
            for ( Post post: seller.getPosts()) {
                postsFollowed.add(new PostDTORes(seller.getUser_id(),post));
            }
        }

        List<PostDTORes> filtradas=postsFollowed.stream().
                filter(p->p.getDate().isAfter(LocalDate.now().minusWeeks(2))).collect(Collectors.toList());

        //if (order.equals("date_asc"))
            //filtradas.stream().sorted((d1,d2)->d1.getDate().isAfter(d2.getDate()));
        //if (order.equals("date_desc"))
            //filtradas.stream().sorted(Comparator.comparing(PostDTORes::getDate).reversed());


        return new PostFollowedByDateDTORes(buyer.getUser_id(), filtradas);
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        UserBuyer buyer = userBuyerRepository.findById(userId);
        UserSeller seller = userSellerRepository.findById(userIdToUnfollow);
        buyer.getFollowed().remove(seller);
        seller.getFollowers().remove(buyer);
    }

    @Override
    public PostFollowedByDateDTORes getLastPostsSortedDate(String order) {
        return null;
    }


}
