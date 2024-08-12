package com.example.demo.limit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RateLimitAspect {

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    @Around("@annotation(rateLimit)")
    public Object limit(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        // 这里可以把key加上其他信息，如客户端ip，以实现对单个ip的限流
        String key = "rateLimit:" + methodName;
        long value = redisTemplate.opsForValue().increment(key, 1);
        if (value == 1) {
            redisTemplate.expire(key, rateLimit.value(), TimeUnit.SECONDS);
        }
        if (value > rateLimit.capacity()) {
            throw new RuntimeException("请求太频繁，请稍后再试！");
        }
        return joinPoint.proceed();
    }
}