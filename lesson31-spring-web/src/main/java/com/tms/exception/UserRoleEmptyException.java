package com.tms.exception;

import com.tms.domain.User;
import lombok.Data;

@Data
public class UserRoleEmptyException extends RuntimeException{
    private User user;

    public UserRoleEmptyException(User user) {
        this.user = user;
    }
}
