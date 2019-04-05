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
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderPhoto;

/**
 * Extension of a {@link JsonPlaceholderPhoto} that allows instantiation using Jackson.
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
    @JsonCreator
    public PhotoDto(
            @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY) final long id,
            @JsonProperty(value = "title", access = JsonProperty.Access.WRITE_ONLY) final String title,
            @JsonProperty(value = "albumId", access = JsonProperty.Access.WRITE_ONLY) final long albumId,
            @JsonProperty(value = "url", access = JsonProperty.Access.WRITE_ONLY) final String url,
            @JsonProperty(value = "thumbnailUrl", access = JsonProperty.Access.WRITE_ONLY) final String thumbnailUrl) {
        super(id, title, albumId, url, thumbnailUrl);
    }
}
