package com.bootcamp.sprint1.service;

import com.bootcamp.sprint1.repository.IUserSellerRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSellerServiceImp implements IUserSellerService{
    private final IUserSellerRepository sellerRepository;

    public UserSellerServiceImp(IUserSellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
}
