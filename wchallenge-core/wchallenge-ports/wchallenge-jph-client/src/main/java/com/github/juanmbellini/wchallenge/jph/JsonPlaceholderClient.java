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

package com.github.juanmbellini.wchallenge.jph;

import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAlbum;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderComment;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderPhoto;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;

import java.util.List;
import java.util.Optional;

/**
 * A JsonPlaceholder client.
 */
public interface JsonPlaceholderClient {

    /**
     * Retrieves the {@link JsonPlaceholderUser}s in the JSONPlaceholder service.
     *
     * @return The {@link List} of {@link JsonPlaceholderUser}s in the JSONPlaceholder service.
     */
    List<JsonPlaceholderUser> retrieveUsers();

    /**
     * Retrieves the {@link JsonPlaceholderPhoto}s in the JSONPlaceholder service.
     *
     * @return The {@link List} of {@link JsonPlaceholderPhoto}s in the JSONPlaceholder service.
     */
    List<JsonPlaceholderPhoto> retrievePhotos();

    /**
     * Retrieves the {@link JsonPlaceholderAlbum}s in the JSONPlaceholder service.
     *
     * @return The {@link List} of {@link JsonPlaceholderAlbum}s in the JSONPlaceholder service.
     */
    List<JsonPlaceholderAlbum> retrieveAlbums();

    /**
     * Retrieves the {@link JsonPlaceholderUser} with the given {@code userId}.
     *
     * @param userId The id of the {@link JsonPlaceholderUser} to be retrieved.
     * @return An {@link Optional} holding the {@link JsonPlaceholderUser} with the given {@code userId} if it exists,
     * or empty otherwise.
     */
    Optional<JsonPlaceholderUser> getUserById(final long userId);

    /**
     * Indicates whether a {@link JsonPlaceholderUser} exists with the given {@code userId}.
     *
     * @param userId The id of the {@link JsonPlaceholderUser} to be checked.
     * @return {@code true} if the {@link JsonPlaceholderUser} exists, or {@code false} otherwise.
     */
    boolean existsUserWithId(final long userId);

    /**
     * Retrieves the {@link JsonPlaceholderAlbum}s belonging to the {@link JsonPlaceholderUser}
     * with the given {@code userId}.
     *
     * @param userId The id of the {@link JsonPlaceholderUser} owning the {@link JsonPlaceholderAlbum}s.
     * @return The {@link JsonPlaceholderAlbum}s belonging to the {@link JsonPlaceholderUser}
     * with the given {@code userId}.
     */
    List<JsonPlaceholderAlbum> retrieveUserAlbums(final long userId);

    /**
     * Retrieves the {@link JsonPlaceholderPhoto}s belonging to the {@link JsonPlaceholderUser}
     * with the given {@code userId}.
     *
     * @param userId The id of the {@link JsonPlaceholderUser} owning the {@link JsonPlaceholderPhoto}s.
     * @return The {@link JsonPlaceholderPhoto}s belonging to the {@link JsonPlaceholderUser}
     * with the given {@code userId}.
     */
    List<JsonPlaceholderPhoto> retrieveUserPhotos(final long userId);

    /**
     * Retrieves the {@link JsonPlaceholderComment}s in the JSONPlaceholder service,
     * applying filters for name and email.
     *
     * @param nameFilter  Name filter.
     * @param emailFilter Email filter.
     * @return A {@link List} of matching {@link JsonPlaceholderComment}s in the JSONPlaceholder service.
     */
    List<JsonPlaceholderComment> retrieveComments(final String nameFilter, final String emailFilter);
}
