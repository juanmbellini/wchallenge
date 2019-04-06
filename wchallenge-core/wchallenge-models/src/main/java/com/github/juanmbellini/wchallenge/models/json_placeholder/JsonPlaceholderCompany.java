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

package com.github.juanmbellini.wchallenge.models.json_placeholder;

/**
 * Represents a company of the Json Placeholder Service.
 */
public class JsonPlaceholderCompany {

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
    public JsonPlaceholderCompany(
            final String name,
            final String catchPhrase,
            final String bs) {
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
}
