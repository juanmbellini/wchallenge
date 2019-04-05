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
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAlbum;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;

/**
 * Extension of {@link JsonPlaceholderAlbum} used for sending album information through our REST API.
 */
public class AlbumDto extends JsonPlaceholderAlbum {

    /**
     * Constructor.
     *
     * @param id     The album's id.
     * @param userId The id of the user owning the album.
     * @param title  The album's title.
     */
    private AlbumDto(
            final long id,
            final String title,
            final long userId) {
        super(id, title, userId);
    }


    /**
     * @return The album's id.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    public long getId() {
        return super.getId();
    }

    /**
     * @return The album's title.
     */
    @JsonProperty(value = "title", access = JsonProperty.Access.READ_ONLY)
    public String getTitle() {
        return super.getTitle();
    }

    /**
     * @return The id of the user owning the album.
     */
    @JsonProperty(value = "userId", access = JsonProperty.Access.READ_ONLY)
    public long getUserId() {
        return super.getUserId();
    }


    /**
     * Factory method that creates an {@link AlbumDto} from a {@link JsonPlaceholderUser}.
     *
     * @param album The {@link JsonPlaceholderAlbum} from where data will be taken.
     * @return The given {@code album} but with an {@link AlbumDto} view.
     */
    public static AlbumDto fromJsonPlaceholderAlbum(final JsonPlaceholderAlbum album) {
        return new AlbumDto(
                album.getId(),
                album.getTitle(),
                album.getUserId()
        );
    }
}
