package com.gotod.gototest.services;


import com.gotod.gototest.domain.User;

import java.util.List;

public interface UserService {

    User consultUser(String userName, String password);
    User setUser(User user);
    public User upDateDescription(User user);
    List<User> consultUsers();
}
