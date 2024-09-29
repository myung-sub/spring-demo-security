package com.fxsong.demo.security.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
@Slf4j
public class AppControllerAdvice {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseBody
    public NoResourceFoundException handleException(NoResourceFoundException e) {
        return e;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Exception handleException(Exception e) {
        log.warn("Exception occurred", e);
        return e;
    }
}
