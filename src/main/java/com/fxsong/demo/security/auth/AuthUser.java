package com.fxsong.demo.security.auth;

import com.fxsong.demo.security.user.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUser {
    public static String getEmpNo() {
        return getUser().getEmpNo();
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

        throw new AuthNotFoundException("no UserDetailsImpl found in SecurityContextHolder");
    }
}
