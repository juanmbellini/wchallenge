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
 * Represents a comment of the Json Placeholder Service.
 */
public class JsonPlaceholderComment {

    /**
     * The comment's id.
     */
    private final long id;
    /**
     * The comment's name.
     */
    private final String name;
    /**
     * The comment's body.
     */
    private final String body;
    /**
     * The email of the person that created the comment.
     */
    private final String email;
    /**
     * The id of the post being commented.
     */
    private final long postId;


    /**
     * Constructor.
     *
     * @param id     The comment's id.
     * @param name   The comment's name.
     * @param body   The comment's body.
     * @param email  The email of the person that creates the comment.
     * @param postId The id of the post being commented.
     */
    public JsonPlaceholderComment(
            final long id,
            final String name,
            final String body,
            final String email,
            final long postId) {
        this.id = id;
        this.name = name;
        this.body = body;
        this.email = email;
        this.postId = postId;
    }


    /**
     * @return The comment's id.
     */
    public long getId() {
        return id;
    }

    /**
     * @return The comment's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The comment's body.
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
     * @return The id of the post being commented.
     */
    public long getPostId() {
        return postId;
    }
}
