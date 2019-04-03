package com.github.juanmbellini.wchallenge.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class in charge of configuring web concerns.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.github.juanmbellini.wchallenge.rest.controller"
})
public class WebConfig {
}
