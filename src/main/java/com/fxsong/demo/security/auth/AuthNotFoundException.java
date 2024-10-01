package com.fxsong.demo.security.auth;

import org.springframework.security.core.AuthenticationException;

public class AuthNotFoundException extends AuthenticationException {
    public AuthNotFoundException(String msg) {
        super(msg);
    }
}
