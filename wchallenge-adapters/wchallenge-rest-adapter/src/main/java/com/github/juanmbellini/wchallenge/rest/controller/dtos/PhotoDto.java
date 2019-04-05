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
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderPhoto;

/**
 * Extension of {@link JsonPlaceholderPhoto} used for sending photo information through our REST API.
 */
public class PhotoDto extends JsonPlaceholderPhoto {

    /**
     * Constructor.
     *
     * @param id           The photo's id.
     * @param title        The photo's title.
     * @param albumId      The id of the album to which the photo belongs to.
     * @param url          The url where the photo can be found.
     * @param thumbnailUrl The url of the thumbnail of this photo.
     */
    private PhotoDto(
            final long id,
            final String title,
            final long albumId,
            final String url,
            final String thumbnailUrl) {
        super(id, title, albumId, url, thumbnailUrl);
    }


    /**
     * @return The photo's id.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    public long getId() {
        return super.getId();
    }

    /**
     * @return The photo's title.
     */
    @JsonProperty(value = "title", access = JsonProperty.Access.READ_ONLY)
    public String getTitle() {
        return super.getTitle();
    }

    /**
     * @return The id of the album to which the photo belongs to.
     */
    @JsonProperty(value = "albumId", access = JsonProperty.Access.READ_ONLY)
    public long getAlbumId() {
        return super.getAlbumId();
    }

    /**
     * @return The url where the photo can be found.
     */
    @JsonProperty(value = "url", access = JsonProperty.Access.READ_ONLY)
    public String getUrl() {
        return super.getUrl();
    }

    /**
     * @return The url of the thumbnail of this photo.
     */
    @JsonProperty(value = "thumbnailUrl", access = JsonProperty.Access.READ_ONLY)
    public String getThumbnailUrl() {
        return super.getThumbnailUrl();
    }


    /**
     * Factory method that creates a {@link PhotoDto} from a {@link JsonPlaceholderPhoto}.
     *
     * @param photo The {@link JsonPlaceholderPhoto} from where data will be taken.
     * @return The given {@code photo} but with an {@link PhotoDto} view.
     */
    public static PhotoDto fromJsonPlaceholderPhoto(final JsonPlaceholderPhoto photo) {
        return new PhotoDto(
                photo.getId(),
                photo.getTitle(),
                photo.getAlbumId(),
                photo.getUrl(),
                photo.getThumbnailUrl()
        );
    }
}
