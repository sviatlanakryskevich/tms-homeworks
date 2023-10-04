package com.tms.pattern.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private String login;
    private String password;
    private String vipNumber;
}
