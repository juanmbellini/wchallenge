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

import com.bellotapps.webapps_commons.exceptions.NoSuchEntityException;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAlbum;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderPhoto;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;

import java.util.List;

/**
 * A port into the application that allows accessing the Json Placeholder wrapper service.
 */
public interface JsonPlaceholderWrapperService {

    /**
     * Retrieves all the {@link JsonPlaceholderUser}s.
     *
     * @return The {@link List} of {@link JsonPlaceholderUser}s.
     */
    List<JsonPlaceholderUser> getUsers();

    /**
     * Retrieves all the {@link JsonPlaceholderPhoto}s.
     *
     * @return The {@link List} of {@link JsonPlaceholderPhoto}s.
     */
    List<JsonPlaceholderPhoto> getAllPhotos();

    /**
     * Retrieves all the {@link JsonPlaceholderAlbum}s.
     *
     * @return The {@link List} of {@link JsonPlaceholderAlbum}s.
     */
    List<JsonPlaceholderAlbum> getAllAlbums();

    /**
     * Retrieves all the {@link JsonPlaceholderAlbum}s belonging to a given {@link JsonPlaceholderUser}.
     *
     * @param userId The {@link JsonPlaceholderUser}'s id.
     * @return The {@link List} of {@link JsonPlaceholderAlbum}s belonging to the {@link JsonPlaceholderUser}
     * with the given {@code userId}.
     * @throws NoSuchEntityException If there is no {@link JsonPlaceholderUser} with the given {@code userId}.
     */
    List<JsonPlaceholderAlbum> getUserAlbums(final long userId) throws NoSuchEntityException;

    /**
     * Retrieves all the {@link JsonPlaceholderPhoto}s belonging to a given {@link JsonPlaceholderUser}.
     *
     * @param userId The {@link JsonPlaceholderUser}'s id.
     * @return The {@link List} of {@link JsonPlaceholderPhoto}s belonging to the {@link JsonPlaceholderUser}
     * with the given {@code userId}.
     * @throws NoSuchEntityException If there is no {@link JsonPlaceholderUser} with the given {@code userId}.
     */
    List<JsonPlaceholderPhoto> getUserPhotos(final long userId) throws NoSuchEntityException;
}
