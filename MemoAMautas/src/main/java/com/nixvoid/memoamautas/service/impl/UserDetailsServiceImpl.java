package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.exception.UserNotFoundException;
import com.nixvoid.memoamautas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetailsOptional = this.userRepository.getUserInfo(username);
        if(userDetailsOptional == null){
            throw new UserNotFoundException("User not found");
        }
        return userDetailsOptional;
    }
}
