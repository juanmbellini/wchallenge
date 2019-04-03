package com.github.juanmbellini.wchallenge.domain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the domain's module.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.github.juanmbellini.wchallenge.domain"
})
public class DomainConfig {
}
