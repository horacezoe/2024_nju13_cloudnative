package com.example.demo.limit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {
    int value() default 2; // 时间周期，为2则2秒内最多请求10次令牌
    int capacity() default 10; // 令牌桶容量，默认为10个令牌
}
