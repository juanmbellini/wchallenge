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

package com.github.juanmbellini.wchallenge.domain;

import com.bellotapps.webapps_commons.exceptions.NoSuchEntityException;
import com.github.juanmbellini.wchallenge.jph.JsonPlaceholderClient;
import com.github.juanmbellini.wchallenge.models.User;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAlbum;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderComment;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderPhoto;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;
import com.github.juanmbellini.wchallenge.repositories.UserRepository;
import com.github.juanmbellini.wchallenge.services.JsonPlaceholderWrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class implementing the business logic.
 */
@Service
public class Manager implements JsonPlaceholderWrapperService {

    /**
     * Repository for {@link User}s.
     */
    private final UserRepository userRepository;

    /**
     * A client for the JsonPlaceholder service.
     */
    private final JsonPlaceholderClient jsonPlaceholderClient;

    /**
     * Constructor.
     *
     * @param userRepository        Repository for {@link User}s.
     * @param jsonPlaceholderClient A client for the JsonPlaceholder service.
     */
    @Autowired
    public Manager(final UserRepository userRepository, final JsonPlaceholderClient jsonPlaceholderClient) {
        this.userRepository = userRepository;
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }


    @Override
    public List<JsonPlaceholderUser> getUsers() {
        return jsonPlaceholderClient.retrieveUsers();
    }

    @Override
    public List<JsonPlaceholderPhoto> getAllPhotos() {
        return jsonPlaceholderClient.retrievePhotos();
    }

    @Override
    public List<JsonPlaceholderAlbum> getAllAlbums() {
        return jsonPlaceholderClient.retrieveAlbums();
    }

    @Override
    public List<JsonPlaceholderAlbum> getUserAlbums(final long userId) throws NoSuchEntityException {
        return jsonPlaceholderClient.getUserById(userId)
                .map(JsonPlaceholderUser::getId)
                .map(jsonPlaceholderClient::retrieveUserAlbums)
                .orElseThrow(() -> new NoSuchEntityException("There is no user with the given id"));
    }

    @Override
    public List<JsonPlaceholderPhoto> getUserPhotos(final long userId) throws NoSuchEntityException {
        return jsonPlaceholderClient.getUserById(userId)
                .map(JsonPlaceholderUser::getId)
                .map(jsonPlaceholderClient::retrieveUserPhotos)
                .orElseThrow(() -> new NoSuchEntityException("There is no user with the given id"));
    }

    @Override
    public List<JsonPlaceholderComment> getComments(final String nameFilter, final String emailFilter) {
        return jsonPlaceholderClient.retrieveComments(nameFilter, emailFilter);
    }
}
