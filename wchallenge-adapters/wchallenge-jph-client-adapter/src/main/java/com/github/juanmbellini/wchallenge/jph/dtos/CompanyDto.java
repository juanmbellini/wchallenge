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

package com.github.juanmbellini.wchallenge.jph.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderCompany;

/**
 * Extension of a {@link JsonPlaceholderCompany} that allows instantiation using Jackson.
 */
public class CompanyDto extends JsonPlaceholderCompany {

    /**
     * Constructor.
     *
     * @param name        The company's name.
     * @param catchPhrase The company's catch phrase.
     * @param bs          The company's bs.
     */
    @JsonCreator
    public CompanyDto(
            @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY) final String name,
            @JsonProperty(value = "catchPhrase", access = JsonProperty.Access.WRITE_ONLY) final String catchPhrase,
            @JsonProperty(value = "bs", access = JsonProperty.Access.WRITE_ONLY) final String bs) {
        super(name, catchPhrase, bs);
    }
}
