package com.tms.service;

import com.tms.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void saveUser(User user);
}
