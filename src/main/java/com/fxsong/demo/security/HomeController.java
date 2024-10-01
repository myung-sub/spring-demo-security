package com.fxsong.demo.security;

import com.fxsong.demo.security.auth.AuthUser;
import com.fxsong.demo.security.auth.UserDetailsImpl;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
class HomeController {
    @GetMapping
    String index() {
        var context = SecurityContextHolder.getContext();
        return "/index.html";
    }

    @GetMapping("/home")
    String home(HttpSession session) {
        log.debug("user Soeid: {}", AuthUser.getSoeid());
        log.debug("user Name: {}", AuthUser.getName());
        return "/home.html";
    }

    @GetMapping("/admin")
    String admin(HttpSession session) {
        return "/admin.html";
    }
}