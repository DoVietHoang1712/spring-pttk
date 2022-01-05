//package com.hoangdo.pttk.service.impl;
//
//import com.hoangdo.pttk.database.entity.UserEntity;
//import com.hoangdo.pttk.database.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtUserDetailsService implements UserDetailsService {
//    private final UserRepository userRepository;
//    @Autowired
//    public JwtUserDetailsService(@Lazy UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: "+username);
//        } else {
//            return (UserDetails) user;
//        }
//    }
//}
