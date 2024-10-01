package com.fxsong.demo.security.auth;

import com.fxsong.demo.security.user.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuthUser {
    public static String getSoeid() {
        return getUser().getSoeid();
    }

    public static String getName() {
        return getUser().getName();
    }

    private static User getUser() {
        return getPrincipal().getUser();
    }

    private static UserDetailsImpl getPrincipal() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetailsImpl userDetails) {
            return userDetails;
        }
        throw new IllegalStateException("Principal is not UserDetailsImpl : " + authentication);
    }
}
