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
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;

/**
 * Extension of a {@link JsonPlaceholderUser} that allows instantiation using Jackson.
 */
public class UserDto extends JsonPlaceholderUser {


    /**
     * Constructor.
     *
     * @param id       The user's id.
     * @param name     The user's name.
     * @param username The username.
     * @param email    The user's email.
     * @param address  The user's {@link AddressDto}.
     * @param phone    The user's phone.
     * @param website  The user's website.
     * @param company  The user's {@link CompanyDto}.
     */
    @JsonCreator
    public UserDto(
            @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY) final long id,
            @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY) final String name,
            @JsonProperty(value = "username", access = JsonProperty.Access.WRITE_ONLY) final String username,
            @JsonProperty(value = "email", access = JsonProperty.Access.WRITE_ONLY) final String email,
            @JsonProperty(value = "address", access = JsonProperty.Access.WRITE_ONLY) final AddressDto address,
            @JsonProperty(value = "phone", access = JsonProperty.Access.WRITE_ONLY) final String phone,
            @JsonProperty(value = "website", access = JsonProperty.Access.WRITE_ONLY) final String website,
            @JsonProperty(value = "company", access = JsonProperty.Access.WRITE_ONLY) final CompanyDto company) {
        super(id, name, username, email, address, phone, website, company);
    }
}
