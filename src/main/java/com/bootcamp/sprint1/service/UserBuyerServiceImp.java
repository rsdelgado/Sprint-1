package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.dto.respose.*;
import com.bootcamp.sprint1.entity.Post;
import com.bootcamp.sprint1.entity.UserBuyer;
import com.bootcamp.sprint1.entity.UserSeller;
import com.bootcamp.sprint1.exception.BadRequestException;
import com.bootcamp.sprint1.repository.IUserBuyerRepository;
import com.bootcamp.sprint1.repository.IUserSellerRepository;
import com.bootcamp.sprint1.util.Sorter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        if (!order.equals("invalid"))
            Sorter.sortedByName(userDTOResList,order);
        else
            throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");
        return new FollowedListDTORes(buyer.getUser_id(),buyer.getUser_name(),userDTOResList);
    }

    @Override
    public PostFollowedByDateDTORes getLastPosts(Integer userId, String order) {
        UserBuyer buyer= userBuyerRepository.findById(userId);
        List<UserSeller> followed = buyer.getFollowed();
        List<PostDTORes> postsFollowed =  new ArrayList<>();
        getPostListSeller(followed,postsFollowed);

        List<PostDTORes> filterList= filterPostByDate(postsFollowed);

        if(!order.equals("invalid"))
            Sorter.sortByDate(filterList,order);
        return new PostFollowedByDateDTORes(buyer.getUser_id(), filterList);
    }

    private List<PostDTORes> filterPostByDate(List<PostDTORes> postDTOResList){
        return postDTOResList.stream().
                filter(postDTORes->postDTORes.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList());
    }
    private void getPostListSeller(List<UserSeller> followed, List<PostDTORes> postsFollowed){
        for (UserSeller seller: followed) {
            for ( Post post: seller.getPosts()) {
                postsFollowed.add(new PostDTORes(seller.getUser_id(),post));
            }
        }
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        UserBuyer buyer = userBuyerRepository.findById(userId);
        UserSeller seller = userSellerRepository.findById(userIdToUnfollow);
        buyer.getFollowed().remove(seller);
        seller.getFollowers().remove(buyer);
    }

}
