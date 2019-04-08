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

package com.github.juanmbellini.wchallenge.repositories;

import com.github.juanmbellini.wchallenge.models.Permission;
import com.github.juanmbellini.wchallenge.models.SharedAlbumPermission;

import java.util.List;
import java.util.Optional;

/**
 * A port out of the application that allows {@link SharedAlbumPermission} persistence.
 */
public interface SharedAlbumPermissionsRepository {

    /**
     * Saves the given {@code sharedAlbumPermission}.
     * Use the returned {@link SharedAlbumPermission} instance for further operation.
     *
     * @param sharedAlbumPermission The {@link SharedAlbumPermission} to be saved.
     * @param <S>                   Concrete subtype of {@link SharedAlbumPermission}.
     * @return The saved instance.
     * @throws IllegalArgumentException If the given {@code sharedAlbumPermission} is {@code null}.
     */
    <S extends SharedAlbumPermission> S save(final S sharedAlbumPermission) throws IllegalArgumentException;

    /**
     * Deletes the given {@code sharedAlbumPermission}.
     *
     * @param sharedAlbumPermission The {@link SharedAlbumPermission} to be deleted.
     * @param <S>                   Concrete subtype of {@link SharedAlbumPermission}.
     * @throws IllegalArgumentException If the given {@code sharedAlbumPermission} is {@code null}.
     */
    <S extends SharedAlbumPermission> void delete(final S sharedAlbumPermission) throws IllegalArgumentException;

    /**
     * Retrieves the id of the users that have the given {@code permission}
     * over the album with the given {@code albumId}.
     *
     * @param albumId    The id of the album to check.
     * @param permission The {@link Permission} to check.
     * @return The {@link List} of users' ids that have the given {@code permission}
     * over the album with the given {@code albumId}.
     */
    List<Long> usersWithPermission(final long albumId, final Permission permission);

    /**
     * Indicates whether the user with the given {@code userId} has the given {@code permission}
     * over the album with the given {@code albumId}.
     *
     * @param albumId    The id of the album to check.
     * @param userId     The id of the user to check.
     * @param permission The {@link Permission} to check.
     * @return {@code true} if the user with the given {@code userId} has the given {@code permission}
     * over the album with the given {@code albumId}, or {@code false} otherwise.
     */
    boolean hasPermission(final long albumId, final long userId, final Permission permission);

    /**
     * Retrieves the {@link SharedAlbumPermission} that has
     * the given {@code albumId}, {@code userId} and {@code permission}.
     *
     * @param albumId    The id of the album.
     * @param userId     The id of the user.
     * @param permission The {@link Permission}.
     * @return An {@link Optional} of {@link SharedAlbumPermission} if it exists,
     * or an empty {@link Optional} otherwise.
     */
    Optional<SharedAlbumPermission> retrieve(final long albumId, final long userId, final Permission permission);

    /**
     * Removes all the {@link Permission}s granted to the user with the given {@code userId}
     * over the album with the given {@code albumId}.
     *
     * @param albumId The id of the album.
     * @param userId  The id of the user.
     */
    void removeAllForAlbumAndUser(final long albumId, final long userId);

    /**
     * Removes all the {@link Permission}s granted for all albums to the user with the given {@code userId}.
     *
     * @param userId The id of the user.
     */
    void removeAllForUser(final long userId);

    /**
     * Removes all the {@link Permission}s granted to all users over the album with the given {@code albumId}.
     *
     * @param albumId The id of the album.
     */
    void removeAllForAlbum(final long albumId);
}
