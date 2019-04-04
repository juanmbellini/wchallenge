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

import com.github.juanmbellini.wchallenge.models.Album;
import com.github.juanmbellini.wchallenge.models.Photo;
import com.github.juanmbellini.wchallenge.models.User;

import java.util.List;

/**
 * A port into the application that allows {@link User} management.
 */
public interface UserService {

    /**
     * Retrieves all the {@link User}s.
     *
     * @return The {@link List} of {@link User}s.
     */
    List<User> getUsers();

    /**
     * Retrieves all the {@link Photo}s.
     *
     * @return The {@link List} of {@link Photo}s.
     */
    List<Photo> getAllPhotos();

    /**
     * Retrieves all the {@link Album}s.
     *
     * @return The {@link List} of {@link Album}s.
     */
    List<Album> getAllAlbums();

    /**
     * Retrieves all the {@link Album}s belonging to a given {@link User}.
     *
     * @param userId The {@link User}'s id.
     * @return The {@link List} of {@link Album}s belonging to the {@link User} with the given {@code userId}.
     */
    List<Album> getUserAlbums(final long userId);

    /**
     * Retrieves all the {@link Photo}s belonging to a given {@link User}.
     *
     * @param userId The {@link User}'s id.
     * @return The {@link List} of {@link Photo}s belonging to the {@link User} with the given {@code userId}.
     */
    List<Photo> getUserPhotos(final long userId);
}
