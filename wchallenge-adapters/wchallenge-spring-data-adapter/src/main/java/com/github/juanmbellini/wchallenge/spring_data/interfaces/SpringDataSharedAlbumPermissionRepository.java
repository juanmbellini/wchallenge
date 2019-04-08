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

package com.github.juanmbellini.wchallenge.spring_data.interfaces;

import com.github.juanmbellini.wchallenge.models.Permission;
import com.github.juanmbellini.wchallenge.models.SharedAlbumPermission;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * A repository for {@link SharedAlbumPermission}.
 */
@org.springframework.stereotype.Repository
public interface SpringDataSharedAlbumPermissionRepository extends Repository<SharedAlbumPermission, Long> {

    /**
     * Saves the given {@code sharedAlbumPermission} instance.
     *
     * @param sharedAlbumPermission The {@link SharedAlbumPermission} instance to be saved.
     * @param <S>                   Concrete subtype of {@link SharedAlbumPermission}.
     * @return The saved {@link SharedAlbumPermission} instance.
     * @throws IllegalArgumentException If the given {@code sharedAlbumPermission} is {@code null}.
     */
    <S extends SharedAlbumPermission> S save(final S sharedAlbumPermission) throws IllegalArgumentException;

    /**
     * Deletes the given {@code sharedAlbumPermission} instance.
     *
     * @param sharedAlbumPermission The {@link SharedAlbumPermission} instance to be deleted.
     * @param <S>                   Concrete subtype of {@link SharedAlbumPermission}.
     * @throws IllegalArgumentException If the given {@code sharedAlbumPermission} is {@code null}.
     */
    <S extends SharedAlbumPermission> void delete(final S sharedAlbumPermission) throws IllegalArgumentException;

    /**
     * Retrieves the id of the users that have the given {@code permission}
     * over the album with the given {@code albumId}.
     *
     * @param albumId    The id of the album to be checked.
     * @param permission The {@link Permission} to be checked.
     * @return The id of the users with the given {@code permission} over the album with the given {@code id}
     * (in a {@link OnlyUserIdOfSharedAlbumPermissionProjection} instance).
     */
    List<OnlyUserIdOfSharedAlbumPermissionProjection> getUserIdByAlbumIdAndPermission(
            final long albumId,
            final Permission permission
    );

    /**
     * Indicates whether a {@link SharedAlbumPermission} exists with the given arguments.
     *
     * @param albumId    The id of the album to be checked.
     * @param userId     The id of the user to be checked.
     * @param permission The {@link Permission} to be checked.
     * @return {@code true} if it exists, or {@code false} otherwise.
     */
    boolean existsByAlbumIdAndUserIdAndPermission(final long albumId, final long userId, final Permission permission);

    /**
     * Retrieves the {@link SharedAlbumPermission} with the given {@code arguments}.
     *
     * @param albumId    The id of the album.
     * @param userId     The id of the user.
     * @param permission The {@link Permission}.
     * @return An {@link Optional} of {@link SharedAlbumPermission} if it exists,
     * or an empty {@link Optional} otherwise.
     */
    Optional<SharedAlbumPermission> getByAlbumIdAndUserIdAndPermission(
            final long albumId,
            final long userId,
            final Permission permission
    );

    /**
     * Deletes all the {@link SharedAlbumPermission}s that match the given {@code albumId} and {@code userId}.
     *
     * @param albumId The id of the album.
     * @param userId  The id of the user.
     */
    void deleteByAlbumIdAndUserId(final long albumId, final long userId);

    /**
     * Deletes all the {@link SharedAlbumPermission} that match the given {@code userId}.
     *
     * @param userId The id of the user.
     */
    void deleteByUserId(final long userId);

    /**
     * Deletes all the {@link SharedAlbumPermission} that match the given {@code albumId}.
     *
     * @param albumId The id of the album.
     */
    void deleteByAlbumId(final long albumId);

    /**
     * A projection interface that allows retrieving only the id of a {@link SharedAlbumPermission}.
     */
    interface OnlyUserIdOfSharedAlbumPermissionProjection {

        /**
         * @return The id of the user.
         */
        @Value("#{target.userId}")
        long getId();
    }
}
