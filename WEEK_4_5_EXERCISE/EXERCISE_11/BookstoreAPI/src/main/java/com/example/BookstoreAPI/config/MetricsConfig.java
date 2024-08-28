package main.java.com.example.BookstoreAPI.config;

import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;

@Configuration
public class MetricsConfig {

    @Bean
    public CustomMetrics customMetrics(MeterRegistry meterRegistry) {
        return new CustomMetrics(meterRegistry);
    }

    public static class CustomMetrics {
        private final Counter customCounter;

        public CustomMetrics(MeterRegistry meterRegistry) {
            this.customCounter = meterRegistry.counter("custom_metric", "type", "example");
        }

        public void incrementCustomCounter() {
            customCounter.increment();
        }
    }
}
