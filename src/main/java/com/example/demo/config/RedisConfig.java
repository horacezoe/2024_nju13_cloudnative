package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {

    @Bean
    @Primary
    public RedisTemplate<String, Integer> redisTemplate() {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(new LettuceConnectionFactory());
        return template;
    }
}