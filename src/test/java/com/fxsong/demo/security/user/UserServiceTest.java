package com.fxsong.demo.security.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    void findBySoeid() {
        // when
        var user = service.findBySoeid("ms88160");

        // then
        assertNotNull(user);
    }

}