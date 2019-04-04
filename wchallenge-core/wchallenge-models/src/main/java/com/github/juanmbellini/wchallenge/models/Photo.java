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

import org.springframework.util.Assert;

import java.util.Objects;

/**
 * Represents a photo.
 */
public class Photo {

    /**
     * The photo's id.
     */
    private final long id;

    /**
     * The photo's title.
     */
    private final String title;

    /**
     * The {@link Album} to which this photo belongs to.
     */
    private final Album album;

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
     * @param album        The {@link Album} to which this photo belongs to.
     * @param url          The url where the photo can be found.
     * @param thumbnailUrl The url of the thumbnail of this photo.
     */
    public Photo(final long id, final String title, final Album album, final String url, final String thumbnailUrl) {
        Assert.hasText(title, "The title must have text");
        Assert.hasText(url, "The url must have text");
        Assert.hasText(thumbnailUrl, "The thumbnail url must have text");
        Assert.notNull(album, "The album must not be null");
        this.id = id;
        this.title = title;
        this.album = album;
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
     * @return The {@link Album} to which this photo belongs to.
     */
    public Album getAlbum() {
        return album;
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


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Photo)) {
            return false;
        }
        final var photo = (Photo) o;
        return id == photo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album=" + album +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
