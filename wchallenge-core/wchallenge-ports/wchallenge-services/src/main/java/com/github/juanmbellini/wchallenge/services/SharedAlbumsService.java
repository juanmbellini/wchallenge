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

package com.github.juanmbellini.wchallenge.services;

import com.github.juanmbellini.wchallenge.models.Permission;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;

import java.util.List;
import java.util.Set;

/**
 * A port into the application that allows granting permissions to a user over an album.
 */
public interface SharedAlbumsService {

    /**
     * Grants the given {@code permission} to the user with the given {@code userId},
     * over the album with the given {@code albumId}.
     *
     * @param albumId    The id of the album.
     * @param userId     The id of the user.
     * @param permission The permission to be granted.
     * @apiNote This is an idempotent action.
     */
    void addPermission(final long albumId, final long userId, final Permission permission);

    /**
     * Removes the given {@code permission} to the user with the given {@code userId},
     * over the album with the given {@code albumId}.
     *
     * @param albumId    The id of the album.
     * @param userId     The id of the user.
     * @param permission The permission to be granted.
     * @apiNote This is an idempotent action.
     */
    void removePermission(final long albumId, final long userId, final Permission permission);

    /**
     * Replaces the permissions the user with the given {@code userId} has
     * over the album with the given {@code albumId}, with the given {@code permissions}.
     *
     * @param albumId     The id of the album.
     * @param userId      The id of the user.
     * @param permissions The permission to be set.
     */
    void setPermissions(final long albumId, final long userId, final Set<Permission> permissions);

    /**
     * Removes all the permissions the user with the given {@code userId}
     * has over the album with the given {@code userId}.
     *
     * @param albumId The id of the album.
     * @param userId  The id of the user.
     */
    void removeAllPermissions(final long albumId, final long userId);

    /**
     * Removes all permissions for all albums for the user with the given {@code userId}.
     * This method is intended to be used when a user is removed.
     *
     * @param userId The id of the user.
     */
    void removeUserPermissions(final long userId);

    /**
     * Removes all permissions for all users for the album with the given {@code albumId}.
     * This method is intended to be used when an album is removed.
     *
     * @param albumId The id of the album.
     */
    void removeAlbumPermissions(final long albumId);

    /**
     * Retrieves all the {@link JsonPlaceholderUser}s that have the given {@code permission}
     * over the album with the given {@code albumId}.
     *
     * @param albumId    The id of the album.
     * @param permission The permission to be checked.
     * @return The {@link JsonPlaceholderUser} that have the given {@code permission}
     * over the album with the given {@code albumId}.
     */
    List<JsonPlaceholderUser> hasPermission(final long albumId, final Permission permission);

}
