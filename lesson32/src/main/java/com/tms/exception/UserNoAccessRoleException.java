package com.tms.exception;

import com.tms.domain.User;
import lombok.Data;

@Data
public class UserNoAccessRoleException extends RuntimeException{
    private User user;

    public UserNoAccessRoleException(User user) {
        this.user = user;
    }
}
