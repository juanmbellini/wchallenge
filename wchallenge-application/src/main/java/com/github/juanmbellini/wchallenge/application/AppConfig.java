package com.github.juanmbellini.wchallenge.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main configuration class.
 */
@Configuration
@ComponentScan(value = {
        "com.github.juanmbellini.wchallenge.*.config"
})
public class AppConfig {
}
