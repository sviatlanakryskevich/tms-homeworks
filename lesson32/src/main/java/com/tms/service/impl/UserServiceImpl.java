package com.tms.service.impl;

import com.tms.domain.User;
import com.tms.exception.UserNoAccessRoleException;
import com.tms.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
        String role = user.getRole();
        String noAccessRole = "guest";
        if(noAccessRole.equals(role)){
            throw new UserNoAccessRoleException(user);
        }

    }
}
