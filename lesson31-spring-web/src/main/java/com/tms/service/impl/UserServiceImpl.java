package com.tms.service.impl;

import com.tms.domain.User;
import com.tms.exception.UserNameEmptyException;
import com.tms.exception.UserNoAccessRoleException;
import com.tms.exception.UserRoleEmptyException;
import com.tms.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(User user) {
        String name = user.getName();
        String role = user.getRole();
        String noAccessRole = "guest";
        if(name == null || name.isBlank()){
            throw new UserNameEmptyException(user);
        }
        if(role == null || role.isBlank()){
            throw new UserRoleEmptyException(user);
        }
        if(noAccessRole.equals(role)){
            throw new UserNoAccessRoleException(user);
        }

    }
}
