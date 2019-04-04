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

import com.bellotapps.webapps_commons.exceptions.NotImplementedException;
import com.github.juanmbellini.wchallenge.models.Album;
import com.github.juanmbellini.wchallenge.models.Photo;
import com.github.juanmbellini.wchallenge.models.User;
import com.github.juanmbellini.wchallenge.repositories.UserRepository;
import com.github.juanmbellini.wchallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Manager for {@link User}s.
 */
@Service
public class UserManager implements UserService {

    /**
     * Repository for {@link User}s.
     */
    private final UserRepository userRepository;

    /**
     * Constructor.
     *
     * @param userRepository Repository for {@link User}s.
     */
    @Autowired
    public UserManager(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getUsers() {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Photo> getAllPhotos() {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Album> getAllAlbums() {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Album> getUserAlbums(final long userId) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Photo> getUserPhotos(final long userId) {
        throw new NotImplementedException("Not implemented yet");
    }
}
