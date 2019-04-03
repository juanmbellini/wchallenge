package com.github.juanmbellini.wchallenge.models.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the model's module.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.github.juanmbellini.wchallenge.models"
})
public class ModelsConfig {
}
