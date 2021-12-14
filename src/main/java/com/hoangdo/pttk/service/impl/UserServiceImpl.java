package com.hoangdo.pttk.service.impl;

import com.hoangdo.pttk.api.dto.User;
import com.hoangdo.pttk.api.dto.request.UserRQ;
import com.hoangdo.pttk.database.entity.UserEntity;
import com.hoangdo.pttk.database.repository.UserRepository;
import com.hoangdo.pttk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void save(UserRQ userRQ) {
        UserEntity user = new UserEntity();
        user.setUsername(userRQ.getUsername());
        user.setPassword(passwordEncoder.encode(userRQ.getPassword()));
        userRepository.save(user);
    }
}
