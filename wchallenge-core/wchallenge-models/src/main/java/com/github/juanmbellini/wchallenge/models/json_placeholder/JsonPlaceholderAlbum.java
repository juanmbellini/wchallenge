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
 * Represents an album of the Json Placeholder Service.
 */
public class JsonPlaceholderAlbum {

    /**
     * The album's id.
     */
    private final long id;
    /**
     * The album's title.
     */
    private final String title;
    /**
     * The id of the user owning the album.
     */
    private final long userId;


    /**
     * Constructor.
     *
     * @param id     The album's id.
     * @param userId The id of the user owning the album.
     * @param title  The album's title.
     */

    public JsonPlaceholderAlbum(
            final long id,
            final String title,
            final long userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
    }


    /**
     * @return The album's id.
     */
    public long getId() {
        return id;
    }

    /**
     * @return The album's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The id of the user owning the album.
     */
    public long getUserId() {
        return userId;
    }

}
