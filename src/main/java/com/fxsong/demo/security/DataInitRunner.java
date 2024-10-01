package com.fxsong.demo.security;

import com.fxsong.demo.security.user.User;
import com.fxsong.demo.security.user.UserService;
import com.fxsong.demo.security.user.role.UserRole;
import com.fxsong.demo.security.user.role.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitRunner implements ApplicationRunner {

    private final UserService userService;
    private final UserRoleService userRoleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===================================");

        var user = User.builder().empNo("user").name("user name is ...").password("user").build();
        userService.create(user);

        var userRole = UserRole.builder().empNo("asdf").role("ROLE_USER").build();
        userRoleService.create(userRole);

        var admin = User.builder().empNo("admin").name("admin name is ...").password("admin").build();
        userService.create(admin);

        var adminRole = UserRole.builder().empNo("admin").role("ROLE_ADMIN").build();
        userRoleService.create(adminRole);

        var adminRole2 = UserRole.builder().empNo("admin").role("ROLE_USER").build();
        userRoleService.create(adminRole2);

    }
}
