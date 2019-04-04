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
 * Represents an album.
 */
public class Album {

    /**
     * The album's id.
     */
    private final long id;
    /**
     * The album's title.
     */
    private final String title;
    /**
     * The {@link User} that owns the album.
     */
    private final User user;


    /**
     * Constructor.
     *
     * @param id    The album's id.
     * @param user  The {@link User} that owns the album.
     * @param title The album's title.
     */
    public Album(final long id, final String title, final User user) {
        Assert.hasText(title, "The title must have text");
        Assert.notNull(user, "The user must not be null");
        this.id = id;
        this.title = title;
        this.user = user;
    }


    /**
     * @return The album's id.
     */
    public long getId() {
        return id;
    }

    /**
     * @return The album's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The {@link User} that owns the album.
     */
    public User getUser() {
        return user;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Album)) {
            return false;
        }
        final var album = (Album) o;
        return id == album.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                '}';
    }
}
