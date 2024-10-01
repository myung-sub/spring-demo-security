package com.fxsong.demo.security;

import com.fxsong.demo.security.auth.AuthUser;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
class HomeController {
    @GetMapping
    String index() {
        return "index.jsp";
    }

    @GetMapping("/home")
    String home(HttpSession session) {
        log.debug("user Emp No : {}", AuthUser.getEmpNo());
        log.debug("user Name : {}", AuthUser.getName());
        return "home.jsp";
    }

    @GetMapping("/admin")
    String admin(HttpSession session) {
        log.debug("user Emp No : {}", AuthUser.getEmpNo());
        log.debug("user Name : {}", AuthUser.getName());
        return "admin.jsp";
    }

    @PostMapping("/samples")
    @ResponseBody
    String samples(@RequestParam String sample) {
        log.debug("sample : {}", sample);
        return "sample : " + sample;
    }

}