package com.fxsong.demo.security.auth;

import com.fxsong.demo.security.user.UserService;
import com.fxsong.demo.security.user.role.UserRole;
import com.fxsong.demo.security.user.role.UserRoleService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final UserRoleService userRoleService;

    public UserDetailsServiceImpl(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String soeid) throws UsernameNotFoundException {
        var user = userService.findBySoeid(soeid);
        var userRoles = userRoleService.findBySoeId(soeid);
        Collection<GrantedAuthority> authorities = getAuthorities(userRoles);
        return new UserDetailsImpl(user.getSoeid(), user.getPassword(), authorities);
    }

    private Collection<GrantedAuthority> getAuthorities(List<UserRole> userRoles) {
        Collection<GrantedAuthority> authorities = new LinkedList<>();
        userRoles.forEach(item -> authorities.add(new GrantedAuthorityImpl(item.getRole())));
        return authorities;
    }
}
