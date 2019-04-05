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

package com.github.juanmbellini.wchallenge.rest.controller.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderCompany;

/**
 * Extension of {@link JsonPlaceholderCompany} used for sending company information through our REST API.
 */
public class CompanyDto extends JsonPlaceholderCompany {

    /**
     * Constructor.
     *
     * @param name        The company's name.
     * @param catchPhrase The company's catch phrase.
     * @param bs          The company's bs.
     */
    private CompanyDto(
            final String name,
            final String catchPhrase,
            final String bs) {
        super(name, catchPhrase, bs);
    }


    /**
     * @return The company's name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.READ_ONLY)
    public String getName() {
        return super.getName();
    }

    /**
     * @return The company's catch phrase.
     */
    @JsonProperty(value = "catchPhrase", access = JsonProperty.Access.READ_ONLY)
    public String getCatchPhrase() {
        return super.getCatchPhrase();
    }

    /**
     * @return The company's bs.
     */
    @JsonProperty(value = "bs", access = JsonProperty.Access.READ_ONLY)
    public String getBs() {
        return super.getBs();
    }


    /**
     * Factory method that creates a {@link CompanyDto} from a {@link JsonPlaceholderCompany}.
     *
     * @param company The {@link JsonPlaceholderCompany} from where data will be taken.
     * @return The given {@code company} but with a {@link CompanyDto} view.
     */
    public static CompanyDto fromJsonPlaceholderCompany(final JsonPlaceholderCompany company) {
        return new CompanyDto(
                company.getName(),
                company.getCatchPhrase(),
                company.getBs()
        );
    }
}
