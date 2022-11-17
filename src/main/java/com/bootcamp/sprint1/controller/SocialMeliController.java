package com.bootcamp.sprint1.controller;

import com.bootcamp.sprint1.dto.request.PostDTOReq;
import com.bootcamp.sprint1.dto.respose.FollowedListDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerCountDTORes;
import com.bootcamp.sprint1.dto.respose.FollowerListDTORes;
import com.bootcamp.sprint1.service.IPostService;
import com.bootcamp.sprint1.service.IUserBuyerService;
import com.bootcamp.sprint1.service.IUserSellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    private final IUserBuyerService userBuyerService;
    private final IUserSellerService userSellerService;

    private final IPostService postService;

    public SocialMeliController(IUserBuyerService userBuyerService, IUserSellerService userSellerService, IPostService postService) {
        this.userBuyerService = userBuyerService;
        this.userSellerService = userSellerService;
        this.postService = postService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        userBuyerService.follow(userId,userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTORes> followersCount(@PathVariable Integer userId){
        return new ResponseEntity<>(userSellerService.followersCount(userId),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowerListDTORes> getFollowers(@PathVariable Integer userId){
        return new ResponseEntity<>(userSellerService.getFollowers(userId),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedListDTORes> getFollowed(@PathVariable Integer userId){
        return new ResponseEntity<>(userBuyerService.getFollowed(userId),HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> publishPost(@RequestBody PostDTOReq postDTOReq){
        userSellerService.publishPost(postDTOReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
