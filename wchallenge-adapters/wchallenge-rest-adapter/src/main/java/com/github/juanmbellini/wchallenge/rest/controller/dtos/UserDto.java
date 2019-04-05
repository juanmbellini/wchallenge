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
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAddress;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderCompany;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;

/**
 * Extension of {@link JsonPlaceholderUser} used for sending user information through our REST API.
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
    private UserDto(
            final long id,
            final String name,
            final String username,
            final String email,
            final AddressDto address,
            final String phone,
            final String website,
            final CompanyDto company) {
        super(id, name, username, email, address, phone, website, company);
    }


    /**
     * @return The user's id.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    public long getId() {
        return super.getId();
    }

    /**
     * @return The user's name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.READ_ONLY)
    public String getName() {
        return super.getName();
    }

    /**
     * @return The username.
     */
    @JsonProperty(value = "username", access = JsonProperty.Access.READ_ONLY)
    public String getUsername() {
        return super.getUsername();
    }

    /**
     * @return The user's email.
     */
    @JsonProperty(value = "email", access = JsonProperty.Access.READ_ONLY)
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * @return The user's {@link AddressDto}.
     */
    @JsonProperty(value = "address", access = JsonProperty.Access.READ_ONLY)
    public JsonPlaceholderAddress getAddress() {
        return super.getAddress();
    }

    /**
     * @return The user's phone.
     */
    @JsonProperty(value = "phone", access = JsonProperty.Access.READ_ONLY)
    public String getPhone() {
        return super.getPhone();
    }

    /**
     * @return The user's website.
     */
    @JsonProperty(value = "website", access = JsonProperty.Access.READ_ONLY)
    public String getWebsite() {
        return super.getWebsite();
    }

    /**
     * @return The user's {@link CompanyDto}.
     */
    @JsonProperty(value = "company", access = JsonProperty.Access.READ_ONLY)
    public JsonPlaceholderCompany getCompany() {
        return super.getCompany();
    }


    /**
     * Factory method that creates a {@link UserDto} from a {@link JsonPlaceholderUser}.
     *
     * @param user The {@link JsonPlaceholderUser} from where data will be taken.
     * @return The given {@code user} but with a {@link UserDto} view.
     */
    public static UserDto fromJsonPlaceholderUser(final JsonPlaceholderUser user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                AddressDto.fromJsonPlaceholderAddress(user.getAddress()),
                user.getPhone(),
                user.getWebsite(),
                CompanyDto.fromJsonPlaceholderCompany(user.getCompany())
        );
    }
}
