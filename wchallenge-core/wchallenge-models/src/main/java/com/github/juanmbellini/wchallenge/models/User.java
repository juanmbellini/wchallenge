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

package com.github.juanmbellini.wchallenge.models;

import org.springframework.util.Assert;

import java.util.Objects;

/**
 * Represents a user.
 */
public class User {

    /**
     * The user's id.
     */
    private final long id;
    /**
     * The user's name.
     */
    private final String name;
    /**
     * The username.
     */
    private final String username;
    /**
     * The user's email.
     */
    private final String email;
    /**
     * The user's {@link Address}.
     */
    private final Address address;
    /**
     * The user's phone.
     */
    private final String phone;
    /**
     * The user's website.
     */
    private final String website;
    /**
     * The user's {@link Company}.
     */
    private final Company company;


    /**
     * Constructor.
     *
     * @param id       The user's id.
     * @param name     The user's name.
     * @param username The username.
     * @param email    The user's email.
     * @param address  The user's {@link Address}.
     * @param phone    The user's phone.
     * @param website  The user's website.
     * @param company  The user's {@link Company}.
     */
    public User(
            final long id,
            final String name,
            final String username,
            final String email,
            final Address address,
            final String phone,
            final String website,
            final Company company) {
        Assert.hasText(name, "The name must have text");
        Assert.hasText(username, "The username must have text");
        Assert.hasText(email, "The email must have text");
        Assert.hasText(phone, "The phone must have text");
        Assert.hasText(website, "The website must have text");
        Assert.notNull(address, "The address must not be null");
        Assert.notNull(company, "The company must not be null");
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }


    /**
     * @return The user's id.
     */
    public long getId() {
        return id;
    }

    /**
     * @return The user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return The user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return The user's {@link Address}.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @return The user's phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return The user's website.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @return The user's {@link Company}.
     */
    public Company getCompany() {
        return company;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        final var user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
