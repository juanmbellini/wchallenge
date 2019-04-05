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

import com.github.juanmbellini.wchallenge.models.Album;
import com.github.juanmbellini.wchallenge.models.Comment;
import com.github.juanmbellini.wchallenge.models.Photo;
import com.github.juanmbellini.wchallenge.models.User;

import java.util.List;
import java.util.Optional;

/**
 * A JsonPlaceholder client.
 */
public interface JsonPlaceholderClient {

    /**
     * Retrieves the {@link User}s in the JSONPlaceholder service.
     *
     * @return The {@link List} of {@link User}s in the JSONPlaceholder service.
     */
    List<User> retrieveUsers();

    /**
     * Retrieves the {@link Photo}s in the JSONPlaceholder service.
     *
     * @return The {@link List} of {@link Photo}s in the JSONPlaceholder service.
     */
    List<Photo> retrievePhotos();

    /**
     * Retrieves the {@link Album}s in the JSONPlaceholder service.
     *
     * @return The {@link List} of {@link Album}s in the JSONPlaceholder service.
     */
    List<Album> retrieveAlbums();

    /**
     * Retrieves the {@link User} with the given {@code userId}.
     *
     * @param userId The id of the {@link User} to be retrieved.
     * @return An {@link Optional} holding the {@link User} with the given {@code userId} if it exists,
     * or empty otherwise.
     */
    Optional<User> getUserById(final long userId);

    /**
     * Retrieves the {@link Album}s belonging to the {@link User} with the given {@code userId}.
     *
     * @param userId The id of the {@link User} owning the {@link Album}s.
     * @return The {@link Album}s belonging to the {@link User} with the given {@code userId}.
     */
    List<Album> retrieveUserAlbums(final long userId);

    /**
     * Retrieves the {@link Photo}s belonging to the {@link User} with the given {@code userId}.
     *
     * @param userId The id of the {@link User} owning the {@link Photo}s.
     * @return The {@link Photo}s belonging to the {@link User} with the given {@code userId}.
     */
    List<Photo> retrieveUserPhotos(final long userId);

    /**
     * Retrieves the {@link Comment}s in the JSONPlaceholder service, applying filters for name and email.
     *
     * @param nameFilter  Name filter.
     * @param emailFilter Email filter.
     * @return A {@link List} of matching {@link Comment}s in the JSONPlaceholder service.
     */
    List<Comment> retrieveComments(final String nameFilter, final String emailFilter);
}
