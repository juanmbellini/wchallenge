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
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAlbum;

/**
 * Extension of a {@link JsonPlaceholderAlbum} that allows instantiation using Jackson.
 */
public class AlbumDto extends JsonPlaceholderAlbum {

    /**
     * Constructor.
     *
     * @param id     The album's id.
     * @param userId The id of the user owning the album.
     * @param title  The album's title.
     */
    @JsonCreator
    public AlbumDto(
            @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY) final long id,
            @JsonProperty(value = "title", access = JsonProperty.Access.WRITE_ONLY) final String title,
            @JsonProperty(value = "userId", access = JsonProperty.Access.WRITE_ONLY) final long userId) {
        super(id, title, userId);
    }
}
