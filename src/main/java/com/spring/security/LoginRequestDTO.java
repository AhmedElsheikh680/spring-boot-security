package com.spring.security;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginRequestDTO {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

}
