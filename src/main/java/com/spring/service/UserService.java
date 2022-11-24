package com.spring.service;


import com.spring.entity.AppUser;
import com.spring.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<AppUser> findAll(){
        return userRepo.findAll();
    }

    public AppUser findById(Long id){
        return userRepo.findById(id).orElse(null);
    }
    public AppUser save(AppUser user){
        return userRepo.save(user);
    }


}
