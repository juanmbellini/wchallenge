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
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderComment;

/**
 * Extension of {@link JsonPlaceholderComment} used for sending company information through our REST API.
 */
public class CommentDto extends JsonPlaceholderComment {

    /**
     * Constructor.
     *
     * @param id     The comment's id.
     * @param name   The comment's name.
     * @param body   The comment's body.
     * @param email  The email of the person that creates the comment.
     * @param postId The id of the post being commented.
     */
    private CommentDto(
            final long id,
            final String name,
            final String body,
            final String email,
            final long postId) {
        super(id, name, body, email, postId);
    }


    /**
     * @return The comment's id.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    public long getId() {
        return super.getId();
    }

    /**
     * @return The comment's name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.READ_ONLY)
    public String getName() {
        return super.getName();
    }

    /**
     * @return The comment's body.
     */
    @JsonProperty(value = "body", access = JsonProperty.Access.READ_ONLY)
    public String getBody() {
        return super.getBody();
    }

    /**
     * @return The email of the person that created the comment.
     */
    @JsonProperty(value = "email", access = JsonProperty.Access.READ_ONLY)
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * @return The id of the post being commented.
     */
    @JsonProperty(value = "postId", access = JsonProperty.Access.READ_ONLY)
    public long getPostId() {
        return super.getPostId();
    }

    /**
     * Factory method that creates a {@link CommentDto} from a {@link JsonPlaceholderComment}.
     *
     * @param comment The {@link JsonPlaceholderComment} from where data will be taken.
     * @return The given {@code comment} but with a {@link CommentDto} view.
     */
    public static CommentDto fromJsonPlaceholderComment(final JsonPlaceholderComment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getName(),
                comment.getBody(),
                comment.getEmail(),
                comment.getPostId()
        );
    }
}
