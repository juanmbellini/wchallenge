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
 * Represents a company of a {@link User}.
 */
public class Company {

    /**
     * The company's name.
     */
    private final String name;
    /**
     * The company's catch phrase.
     */
    private final String catchPhrase;
    /**
     * The company's bs.
     */
    private final String bs;


    /**
     * Constructor.
     *
     * @param name        The company's name.
     * @param catchPhrase The company's catch phrase.
     * @param bs          The company's bs.
     */
    public Company(final String name, final String catchPhrase, final String bs) {
        Assert.hasText(name, "The name must have text");
        Assert.hasText(catchPhrase, "The catch phrase must have text");
        Assert.hasText(bs, "The bs must have text");
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }


    /**
     * @return The company's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The company's catch phrase.
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * @return The company's bs.
     */
    public String getBs() {
        return bs;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Company)) {
            return false;
        }
        final var company = (Company) o;
        return name.equals(company.name) && catchPhrase.equals(company.catchPhrase) && bs.equals(company.bs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catchPhrase, bs);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
