package com.fxsong.demo.security.auth;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@ToString
public class GrantedAuthorityImpl implements GrantedAuthority {
    private final String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
