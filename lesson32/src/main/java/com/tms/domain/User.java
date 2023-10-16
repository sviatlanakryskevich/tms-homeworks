package com.tms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 10)
    private String name;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 10)
    private String role;

}
