package com.fxsong.demo.security.auth;

import com.fxsong.demo.security.user.UserService;
import com.fxsong.demo.security.user.role.UserRoleService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthUserService implements UserDetailsService {

    private final UserService userService;
    private final UserRoleService userRoleService;

    public AuthUserService(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String soeid) throws UsernameNotFoundException {
        var user = userService.findBySoeid(soeid);
        var userRole = userRoleService.findBySoeId(soeid);
        return new AuthUserDetails(user.getSoeid(), user.getPassword(), null);
    }
}
