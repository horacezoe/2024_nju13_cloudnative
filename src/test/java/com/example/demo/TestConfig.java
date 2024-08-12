package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class TestConfig {

    @Bean
    public RedisTemplate<String, Integer> testRedisTemplate() {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(new LettuceConnectionFactory());
        return template;
    }
}