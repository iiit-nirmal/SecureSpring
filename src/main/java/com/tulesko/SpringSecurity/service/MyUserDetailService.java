package com.tulesko.SpringSecurity.service;

import com.tulesko.SpringSecurity.dao.UserRepo;
import com.tulesko.SpringSecurity.model.User;
import com.tulesko.SpringSecurity.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user == null) {
            System.out.println(username+" :User Not found");
            throw  new UsernameNotFoundException("User not Found");
        }
        return new UserPrincipal(user);
    }
}
