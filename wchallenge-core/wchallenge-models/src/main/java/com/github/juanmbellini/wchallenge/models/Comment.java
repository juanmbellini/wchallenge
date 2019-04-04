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
 * Represents a comment.
 */
public class Comment {

    /**
     * The comment's id.
     */
    private final long id;
    /**
     * The comment's name.
     */
    private final String title;
    /**
     * The comment's body.
     */
    private final String body;
    /**
     * The email of the person that created the comment.
     */
    private final String email;
    /**
     * The {@link Post} being commented.
     */
    private final Post post;


    /**
     * Constructor.
     *
     * @param id    The post's id.
     * @param title The post's title.
     * @param body  The post's body.
     * @param email The email of the person that creates the comment.
     * @param post  The {@link Post} being commented.
     */
    public Comment(final long id, final String title, final String body, final String email, final Post post) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.email = email;
        this.post = post;
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
     * @return The email of the person that created the comment.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return The {@link Post} being commented.
     */
    public Post getPost() {
        return post;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Comment)) {
            return false;
        }
        final var comment = (Comment) o;
        return id == comment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", email='" + email + '\'' +
                ", post=" + post +
                '}';
    }
}
