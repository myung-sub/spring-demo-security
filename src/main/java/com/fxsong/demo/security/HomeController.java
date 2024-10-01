package com.fxsong.demo.security;

import com.fxsong.demo.security.auth.AuthUser;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
class HomeController {
    @GetMapping
    String index() {
        return "/index.html";
    }

    @GetMapping("/home")
    String home(HttpSession session) {
        log.debug("user Emp No : {}", AuthUser.getEmpNo());
        log.debug("user Name : {}", AuthUser.getName());
        return "/home.html";
    }

    @GetMapping("/admin")
    String admin(HttpSession session) {
        log.debug("user Emp No : {}", AuthUser.getEmpNo());
        log.debug("user Name : {}", AuthUser.getName());
        return "/admin.html";
    }
}