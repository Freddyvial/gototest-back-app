package com.gotod.gototest.repositories;


import com.gotod.gototest.domain.User;

import java.util.List;

public interface UserRepository {
    User consultUser(String userName, String password);
    User createUser(User user);
    User upDatePassword(User user);
}
