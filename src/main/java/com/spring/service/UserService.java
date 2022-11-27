package com.spring.service;


import com.spring.entity.AppUser;
import com.spring.repo.UserRepo;
import com.spring.security.AppUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public List<AppUser> findAll(){
        return userRepo.findAll();
    }

    public AppUser findById(Long id){
        return userRepo.findById(id).orElse(null);
    }
    public AppUser save(AppUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = userRepo.findByUserName(username);
        if (!appUser.isPresent()){
            throw new UsernameNotFoundException("Username: "+ username+ " Not Found!!");
        }
//        return new User(appUser.get().getUserName(), appUser.get().getPassword(),getAuthorities(appUser.get()));
        return new AppUserDetails(appUser.get());
    }

//    private static List<GrantedAuthority> getAuthorities(AppUser appUser){
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if (!appUser.getRoles().isEmpty()){
//            appUser.getRoles().forEach(role->{
//                authorities.add(new SimpleGrantedAuthority(role.getName()));
//            });
//        }
//        return authorities;
//    }
}
