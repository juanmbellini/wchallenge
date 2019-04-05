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
 * Data transfer object for receiving photo information from the Json Placeholder service.
 */
public class JsonPlaceholderPhoto {

    /**
     * The photo's id.
     */
    private final long id;

    /**
     * The photo's title.
     */
    private final String title;

    /**
     * The id of the album to which the photo belongs to.
     */
    private final long albumId;

    /**
     * The url where the photo can be found.
     */
    private final String url;

    /**
     * The url of the thumbnail of this photo.
     */
    private final String thumbnailUrl;

    /**
     * Constructor.
     *
     * @param id           The photo's id.
     * @param title        The photo's title.
     * @param albumId      The id of the album to which the photo belongs to.
     * @param url          The url where the photo can be found.
     * @param thumbnailUrl The url of the thumbnail of this photo.
     */
    public JsonPlaceholderPhoto(
            final long id,
            final String title,
            final long albumId,
            final String url,
            final String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.albumId = albumId;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }


    /**
     * @return The photo's id.
     */
    public long getId() {
        return id;
    }

    /**
     * @return The photo's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The id of the album to which the photo belongs to.
     */
    public long getAlbumId() {
        return albumId;
    }

    /**
     * @return The url where the photo can be found.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return The url of the thumbnail of this photo.
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
