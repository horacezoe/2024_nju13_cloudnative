package com.example.demo.exception;

import com.example.demo.limit.RateLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RateLimitExceededException.class)
    public ModelAndView handleRateLimitExceededException(RateLimitExceededException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.TOO_MANY_REQUESTS);
        modelAndView.setViewName("error/429");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}