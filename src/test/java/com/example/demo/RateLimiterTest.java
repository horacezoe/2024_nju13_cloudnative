package com.example.demo;

import com.example.demo.controller.HelloController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
@ComponentScan(basePackages = "com.example.demo")
@Import(TestConfig.class)
public class RateLimiterTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // Any setup if needed
    }

    @Test
    public void testRateLimiter() throws Exception {
        // Send 100 requests which should succeed
        for (int i = 0; i < 100; i++) {
            mockMvc.perform(get("/api/hello"))
                   .andExpect(status().isOk());
        }

        // The 101st request should return 429 Too Many Requests
        mockMvc.perform(get("/api/hello"))
               .andExpect(status().isTooManyRequests());
    }

    @Test
    public void testRateLimiter2() throws Exception {
        // Send 10 requests which should succeed
        for (int i = 0; i < 10; i++) {
            mockMvc.perform(get("/api/hello"))
                   .andExpect(status().isOk());
        }

        // The 11th request should return 429 Too Many Requests
        mockMvc.perform(get("/api/hello"))
               .andExpect(status().isTooManyRequests());
    }
}