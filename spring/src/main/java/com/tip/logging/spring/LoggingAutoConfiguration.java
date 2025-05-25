package com.tip.logging.spring;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class LoggingAutoConfiguration {

    @Bean
    @ConditionalOnWebApplication
    public CorrelationIdFilter correlationIdFilter() {
        return new CorrelationIdFilter();
    }
}