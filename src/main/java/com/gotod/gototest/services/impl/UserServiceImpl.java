package com.gotod.gototest.services.impl;

import com.gotod.gototest.domain.User;
import com.gotod.gototest.repositories.UserRepository;
import com.gotod.gototest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User consultUser(String userName,String password) {

        return userRepository.consultUser(userName,password);
    }
    @Override
    public List<User> consultUsers() {

        return userRepository.consultUsers();
    }
    @Override
    public User setUser(User user) {
        return userRepository.createUser(user);
    }
    @Override
    public User upDateDescription(User user) {
        return userRepository.upDateDescription(user);
    }



}
