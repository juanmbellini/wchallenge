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

import java.util.Objects;

/**
 * Represents a post.
 */
public class Post {

    /**
     * The post's id.
     */
    private final long id;
    /**
     * The post's title.
     */
    private final String title;
    /**
     * The post's body.
     */
    private final String body;
    /**
     * The {@link User} that owns the post.
     */
    private final User user;


    /**
     * Constructor.
     *
     * @param id    The post's id.
     * @param title The post's title.
     * @param body  The post's body.
     * @param user  The {@link User} that owns the post.
     */
    public Post(final long id, final String title, final String body, final User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }


    /**
     * @return The post's id.
     */
    public long getId() {
        return id;
    }

    /**
     * @return The post's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The post's body.
     */
    public String getBody() {
        return body;
    }

    /**
     * @return The {@link User} that owns the post.
     */
    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post)) {
            return false;
        }
        final var post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", user=" + user +
                '}';
    }
}
