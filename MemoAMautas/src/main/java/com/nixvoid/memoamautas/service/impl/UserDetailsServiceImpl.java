package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.domain.UserDetailsImpl;
import com.nixvoid.memoamautas.exception.UserNotFoundException;
import com.nixvoid.memoamautas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userDetailsOptional = new UserDetailsImpl();
        try {
            userDetailsOptional = this.userRepository.getUserInfo(email);
            if(userDetailsOptional == null){
                throw new UserNotFoundException("User not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userDetailsOptional;
    }
}
