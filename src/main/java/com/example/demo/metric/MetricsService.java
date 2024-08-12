package com.example.demo.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {
    private final Counter requestCounter;

    public MetricsService(MeterRegistry registry) {
        this.requestCounter = Counter.builder("myapp.http_requests_total")
                .description("Total number of HTTP requests")
                .register(registry);
    }

    public void recordRequest() {
        requestCounter.increment();
    }
}