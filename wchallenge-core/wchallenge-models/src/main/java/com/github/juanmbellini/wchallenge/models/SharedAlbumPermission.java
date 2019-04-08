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

/**
 * Represents a permission given to a user over an album.
 */
public class SharedAlbumPermission {

    /**
     * The id of the relationship entity.
     */
    private final long id;

    /**
     * The album's id.
     */
    private final long albumId;

    /**
     * The user's id.
     */
    private final long userId;


    /**
     * The {@link Permission}.
     */
    private final Permission permission;

    /**
     * Default constructor.
     */
    /* package */ SharedAlbumPermission() {
        // Initialize final fields with default values.
        this.id = 0;
        this.userId = 0;
        this.albumId = 0;
        this.permission = null;
    }


    /**
     * Constructor.
     *
     * @param albumId    The album's id.
     * @param userId     The user's id.
     * @param permission The {@link Permission}.
     */
    public SharedAlbumPermission(final long albumId, final long userId, final Permission permission) {
        this.id = 0;
        this.userId = userId;
        this.albumId = albumId;
        this.permission = permission;
    }

    /**
     * @return The id of the relationship entity.
     */
    public long getId() {
        return id;
    }

    /**
     * @return The album's id.
     */
    public long getAlbumId() {
        return albumId;
    }

    /**
     * @return The user's id.
     */
    public long getUserId() {
        return userId;
    }


    /**
     * @return The {@link Permission}.
     */
    public Permission getPermission() {
        return permission;
    }
}
