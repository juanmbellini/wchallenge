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

/**
 * Enum containing all the permissions that can be granted to a user.
 */
public enum Permission {

    /**
     * Indicates that a user has permission to read a resource.
     */
    READ,
    /**
     * Indicates that a user has permission to write a resource.
     */
    WRITE,
    ;

    /**
     * Creates a {@link Permission} from the given {@code value}.
     *
     * @param value A {@link String} from where the {@link Permission} will be built.
     * @return The created {@link Permission}.
     */
    public static Permission fromString(final String value) {
        Assert.notNull(value, "The value must be provided.");
        return valueOf(value.toUpperCase());
    }
}
