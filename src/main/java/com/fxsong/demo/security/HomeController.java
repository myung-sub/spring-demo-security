package com.fxsong.demo.security;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
class HomeController {
    @GetMapping
    String index() {
        return "Hello Security App";
    }

    @GetMapping("/home")
    String home(HttpSession session) {
        log.debug("session: {}", session.getId());
        return "/home.html";
    }
}