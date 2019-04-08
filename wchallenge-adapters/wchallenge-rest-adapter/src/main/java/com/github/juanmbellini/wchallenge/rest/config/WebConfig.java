/*
 * Copyright 2019 Juan Marcos Bellini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.juanmbellini.wchallenge.rest.config;

import com.bellotapps.webapps_commons.config.EnableJerseyApplication;
import com.bellotapps.webapps_commons.exceptions.CustomConstraintViolationException;
import com.bellotapps.webapps_commons.validation.jersey.ConstraintViolationExceptionCreator;
import com.bellotapps.webapps_commons.validation.jersey.EnableJerseyValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class in charge of configuring web concerns.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.github.juanmbellini.wchallenge.rest.controller"
})
@EnableJerseyApplication(basePackages = {
        "com.github.juanmbellini.wchallenge.rest.controller.endpoints",
        "com.bellotapps.webapps_commons.data_transfer.jersey.providers",
}, errorHandlersPackages = {
        "com.bellotapps.webapps_commons.error_handlers",
})
@EnableJerseyValidation
public class WebConfig {

    /**
     * Creates a bean of a {@link ConstraintViolationExceptionCreator}
     * that supplies {@link CustomConstraintViolationException}.
     *
     * @return A {@link ConstraintViolationExceptionCreator}.
     */
    @Bean
    public ConstraintViolationExceptionCreator constraintViolationExceptionCreator() {
        return CustomConstraintViolationException::new;
    }
}
