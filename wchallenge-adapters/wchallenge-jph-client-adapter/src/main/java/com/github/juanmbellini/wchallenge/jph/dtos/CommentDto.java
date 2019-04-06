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

package com.github.juanmbellini.wchallenge.jph.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderComment;

/**
 * Extension of a {@link JsonPlaceholderComment} that allows instantiation using Jackson.
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
    @JsonCreator
    public CommentDto(
            @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY) final long id,
            @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY) final String name,

            @JsonProperty(value = "body", access = JsonProperty.Access.WRITE_ONLY) final String body,
            @JsonProperty(value = "email", access = JsonProperty.Access.WRITE_ONLY) final String email,
            @JsonProperty(value = "postId", access = JsonProperty.Access.WRITE_ONLY) final long postId) {
        super(id, name, body, email, postId);
    }
}
