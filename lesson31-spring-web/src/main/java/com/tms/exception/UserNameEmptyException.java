package com.tms.exception;

import com.tms.domain.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UserNameEmptyException extends RuntimeException{
    private User user;

    public UserNameEmptyException(User user) {
        this.user = user;
    }
}
