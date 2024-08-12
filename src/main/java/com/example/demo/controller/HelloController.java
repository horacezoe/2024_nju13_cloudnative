package com.example.demo.controller;

import com.example.demo.limit.RateLimit;
import com.example.demo.metric.MetricsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    private final MetricsService metricsService;

    @Autowired
    public HelloController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @RateLimit(value = 10, capacity = 2)
    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        Map<String, String> response = new HashMap<>();
        response.put("msg", "hello");
        metricsService.recordRequest();
        logger.info("hello");
        return response;
    }
}